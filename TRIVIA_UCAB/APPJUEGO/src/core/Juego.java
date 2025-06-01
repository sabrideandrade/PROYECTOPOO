package core;

import archivo.GuardadoPartidaGson;
import modelo.Usuario;
import pregunta.GestorPreguntasTextoGson;
import pregunta.PreguntaTexto;
import tablero.Tablero;

import java.util.List;
import java.util.Scanner;

public class Juego {
    private Tablero tablero;
    private List<Usuario> jugadores;
    private boolean porTiempo;
    private GestorPreguntasTextoGson gestor;
    private final Scanner scanner = new Scanner(System.in);
    private int turno;

    // core/Juego.java (fragmento relevante)
    public void iniciar() {
        Menu menu = new Menu();
        boolean nueva = menu.mostrarMenuPrincipal();
        if (nueva) {
            PreConfiguracionPartida config = new PreConfiguracionPartida();
            config.configurar();
            this.jugadores = config.getJugadores();
            this.porTiempo = config.esPorTiempo();
            this.tablero = new Tablero();
            gestor = new GestorPreguntasTextoGson("src/data/preguntasJuegoTrivia.json");
            // --- Aquí se inicializa la posición de todos los jugadores en el centro ---
            for (Usuario jugador : jugadores) {
                jugador.setPosicion(72); // 72 es el índice del centro
            }
        } else {
            System.out.println("Carga de partida aun no implementada.");
            return;
        }

        jugar();
        menu.mostrarDespedida();
    }

    private void jugar() {
        turno = 0;
        while (true) {
            Usuario actual = jugadores.get(turno);
            System.out.println("\nTurno de: " + actual.getCorreo());
            tablero.colocarFichaEn(actual.getPosicion());
            tablero.dibujarTablero();

            System.out.println("Presiona ENTER para lanzar el dado...");
            scanner.nextLine();
            int dado = Dado.lanzar();
            System.out.println("Dado: " + dado);

            if (actual.getFicha().todasCompletadas() && Movimiento.puedeEntrarAlCentro(actual, dado)) {
                Movimiento.irAlCentro(actual);
                tablero.colocarFichaEn(72);
                tablero.dibujarTablero();
                if (resolverPreguntaCentro(actual)) {
                    actual.getEstadistica().sumarJuegoGanado();
                    System.out.println(actual.getCorreo() + " ha ganado el juego!");
                    break;
                } else {
                    System.out.println("Respuesta incorrecta. Debes esperar al proximo turno.");
                }
            } else {
                Movimiento.moverUsuario(actual, dado, tablero);
                tablero.dibujarTablero();
                String categoria = tablero.obtenerCategoria(actual.getPosicion());
                if (!categoria.equals("cent") && !categoria.equals("esp")) {
                    if (preguntar(actual, categoria)) {
                        actual.getFicha().completar(categoria);
                    }
                }
            }

            GuardadoPartidaGson.guardar(jugadores, "partida_guardada.json");

            turno = (turno + 1) % jugadores.size();
        }
    }

    private boolean preguntar(Usuario jugador, String categoria) {
        PreguntaTexto pregunta = gestor.siguiente(categoria);
        if (pregunta == null) {
            System.out.println("No hay preguntas para esta categoria.");
            return false;
        }

        System.out.println("Categoraia: " + categoria.toUpperCase());
        System.out.println(pregunta.getPregunta());

        Cronometro crono = new Cronometro();
        if (porTiempo) crono.iniciar();

        System.out.print("Escribe tu respuesta: ");
        String respuestaUsuario = scanner.nextLine();

        if (porTiempo) {
            crono.detener();
            jugador.getEstadistica().agregarTiempo(crono.obtenerSegundosTranscurridos());
        }

        if (pregunta.esCorrecta(respuestaUsuario)) {
            System.out.println("¡Correcto!\n");
            jugador.getEstadistica().sumarCorrecta(categoria);
            return true;
        } else {
            System.out.println("Incorrecto.\n");
            return false;
        }
    }

    private boolean resolverPreguntaCentro(Usuario jugador) {
        System.out.println("Estas en el centro. Elige una categoraa: geo, his, dep, cie, art, ent");
        String cat = scanner.nextLine().toLowerCase();
        return preguntar(jugador, cat);
    }
}
