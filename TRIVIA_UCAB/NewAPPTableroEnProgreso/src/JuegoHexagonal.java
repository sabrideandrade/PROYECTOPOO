import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class JuegoHexagonal {
    // Constantes de colores
    public static final String AZUL = "\uD83D\uDFE6";    // 🟦 (Geografia)
    public static final String AMARILLO = "\uD83D\uDFE8"; // 🟨 (Historia)
    public static final String NARANJA = "\uD83D\uDFE7";  // 🟧 (Deportes/Pasatiempos)
    public static final String VERDE = "\uD83D\uDFE9";    // 🟩 (Ciencias/Naturaleza)
    public static final String ROJO = "\uD83D\uDFE5";     // 🟥 (Casillas rojas - especiales)
    public static final String NEGRO = "\u2B1B";         // ⬛ (Casilla central - Inicio/Fin)
    public static final String BLANCO = "\u2B1C";        // ⬜ (Casillas especiales)
    public static final String MARRON = "\uD83D\uDFEB";  // 🟫 (Casillas marrones - especiales)
    public static final String VACIO = "  ";

    // Símbolos para jugadores
    private static final String[] SIMBOLOS_JUGADORES = {"🔴", "🔵", "🟢", "🟡", "🟣", "🟠"};
    private static final String[] COLORES_PREGUNTAS = {"AZUL", "AMARILLO", "NARANJA", "VERDE", "MORADO", "ROSADO"};

    private String[][] tablero;
    private List<Jugador> jugadores;
    private int jugadorActualIndex;
    private Scanner scanner;
    private Random random;

    public JuegoHexagonal() {
        scanner = new Scanner(System.in);
        random = new Random();
        inicializarTablero();
        inicializarJugadores();
    }

    private void inicializarTablero() {
        tablero = new String[][]{
                {VACIO,VACIO,VACIO,VACIO,VACIO,VACIO,VACIO,   AZUL,BLANCO, NARANJA,BLANCO, NARANJA,VACIO,VACIO,VACIO,VACIO,VACIO,VACIO,VACIO},
                {VACIO,VACIO,VACIO,VACIO,VACIO,VACIO,   ROJO,VACIO,VACIO, VACIO,   VACIO,   VERDE,  VACIO,VACIO,VACIO,VACIO,VACIO,VACIO,VACIO},
                {VACIO,VACIO,VACIO,VACIO,VACIO,   AZUL,VACIO,   AZUL,VACIO,VACIO, VACIO,   NARANJA,VACIO, NARANJA,VACIO,VACIO,VACIO,VACIO,VACIO},
                {VACIO,VACIO,VACIO,VACIO,   BLANCO,VACIO,VACIO,   NARANJA,VACIO,VACIO,VACIO,   AZUL,  VACIO,VACIO,   BLANCO,VACIO,VACIO,VACIO,VACIO},
                {VACIO,VACIO,VACIO,   VERDE,VACIO, VACIO,VACIO,VACIO,   MARRON, VACIO,   MARRON, VACIO,VACIO,VACIO,VACIO,   ROJO, VACIO,VACIO,VACIO},
                {VACIO,VACIO,   BLANCO,VACIO,VACIO, VACIO,VACIO,VACIO,   VERDE,  VACIO,   ROJO,   VACIO,VACIO,VACIO,VACIO,VACIO,   BLANCO,VACIO,VACIO},
                {VACIO,   MARRON,VACIO, VACIO,VACIO, VACIO,VACIO,VACIO,   AMARILLO,VACIO,   ROJO,   VACIO,VACIO,VACIO,VACIO,VACIO,VACIO,   AMARILLO,VACIO},
                {   AMARILLO,   MARRON,   AZUL,   VERDE,  VACIO,   ROJO,  VACIO,   NARANJA,VACIO,   NEGRO,  VACIO,   VERDE,  VACIO,   AZUL,  VACIO,   NARANJA,   ROJO,   AMARILLO,   MARRON},
                {VACIO,   MARRON,VACIO, VACIO,VACIO, VACIO,VACIO,VACIO,   AZUL,   VACIO,   MARRON, VACIO,VACIO,VACIO,VACIO,VACIO,VACIO,   AMARILLO,VACIO},
                {VACIO,VACIO,   BLANCO,VACIO,VACIO, VACIO,VACIO,VACIO,   AMARILLO,VACIO,   NARANJA,VACIO,VACIO,VACIO,VACIO,VACIO,   BLANCO,VACIO,VACIO},
                {VACIO,VACIO,VACIO,   ROJO, VACIO,VACIO, VACIO,VACIO,   ROJO,   VACIO,   AMARILLO,VACIO,VACIO,VACIO,VACIO,   VERDE,  VACIO,VACIO,VACIO},
                {VACIO,VACIO,VACIO,VACIO,   BLANCO,VACIO,VACIO,   MARRON, VACIO,VACIO, VACIO,   VERDE,  VACIO,VACIO,   BLANCO,VACIO,VACIO,VACIO,VACIO},
                {VACIO,VACIO,VACIO,VACIO,VACIO,   VERDE, VACIO,   VERDE,  VACIO,VACIO, VACIO,   ROJO,   VACIO,   ROJO,   VACIO,VACIO,VACIO,VACIO,VACIO},
                {VACIO,VACIO,VACIO,VACIO,VACIO,VACIO,   NARANJA,VACIO,VACIO,VACIO,VACIO,VACIO,   AZUL,  VACIO,VACIO,VACIO,VACIO,VACIO,VACIO,VACIO},
                {VACIO,VACIO,VACIO,VACIO,VACIO,VACIO,VACIO,   VERDE,  BLANCO, AMARILLO,BLANCO, ROJO,   VACIO,VACIO,VACIO,VACIO,VACIO,VACIO,VACIO}
        };
    }

    private void inicializarJugadores() {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   JUEGO HEXAGONAL DE PREGUNTAS POR COLOR   ║");
        System.out.println("╚════════════════════════════════════════════╝");

        System.out.print("\nIngrese el número de jugadores (2-6): ");
        int numJugadores = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        jugadores = new ArrayList<>();
        for (int i = 0; i < numJugadores; i++) {
            System.out.print("Nombre del Jugador " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            jugadores.add(new Jugador(nombre, SIMBOLOS_JUGADORES[i], 7, 9)); // Posición inicial en la casilla negra
        }

        jugadores = Dado.determinarOrdenJugadores(jugadores);
        jugadorActualIndex = 0;
    }

    public void jugar() {
        while (true) {
            Jugador jugadorActual = jugadores.get(jugadorActualIndex);
            Ficha ficha = jugadorActual.getFicha();

            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║ Turno de: " + jugadorActual.getNombre() + " " + ficha.getSimbolo() +
                    " (Turno #" + ficha.getTurno() + ") ║");
            System.out.println("╚════════════════════════════════════════════╝");

            if (jugadorActual.getPasosRestantes() == 0) {
                System.out.println("\nPresiona Enter para lanzar el dado...");
                scanner.nextLine();
                int pasos = Dado.lanzar();
                jugadorActual.setPasosRestantes(pasos);
                System.out.println("¡Dado lanzado! Tienes " + pasos + " movimientos.");
            }

            imprimirTablero();
            mostrarControles(jugadorActual);

            System.out.print("\nIngrese dirección (W/A/S/D/Q/E/Z/C): ");
            String direccion = scanner.nextLine().toUpperCase();

            if (realizarMovimiento(jugadorActual, direccion)) {
                if (jugadorActual.getPasosRestantes() == 0) {
                    manejarCasillaEspecial(jugadorActual);
                    siguienteJugador();
                }
            }
        }
    }

    private boolean realizarMovimiento(Jugador jugador, String direccion) {
        Ficha ficha = jugador.getFicha();
        int[] posicionActual = ficha.getPosicion();

        // Verificar si intenta retroceder
        if (Movimiento.esDireccionContraria(direccion, ficha.getUltimaDireccion())) {
            System.out.println("¡No puedes retroceder en la dirección contraria!");
            return false;
        }

        int[] nuevaPosicion = Movimiento.calcularNuevaPosicion(posicionActual[0], posicionActual[1], direccion);

        if (!Movimiento.validarMovimiento(nuevaPosicion[0], nuevaPosicion[1], tablero)) {
            System.out.println("¡Movimiento no permitido! Límite del tablero o casilla inválida.");
            return false;
        }

        // Restaurar contenido anterior de la casilla
        tablero[posicionActual[0]][posicionActual[1]] = ficha.getContenidoAnterior();

        // Actualizar posición de la ficha
        ficha.setContenidoAnterior(tablero[nuevaPosicion[0]][nuevaPosicion[1]]);
        ficha.getPosicion()[0] = nuevaPosicion[0];
        ficha.getPosicion()[1] = nuevaPosicion[1];
        tablero[nuevaPosicion[0]][nuevaPosicion[1]] = ficha.getSimbolo();

        jugador.agregarMovimiento(direccion);
        jugador.setPasosRestantes(jugador.getPasosRestantes() - 1);

        System.out.println("Movimiento realizado. Pasos restantes: " + jugador.getPasosRestantes());
        return true;
    }

    private void manejarCasillaEspecial(Jugador jugador) {
        Ficha ficha = jugador.getFicha();
        String colorCasilla = ficha.getContenidoAnterior();

        if (colorCasilla.equals(NEGRO)) {
            if (ficha.haCompletadoTodasLasCategorias()) {
                System.out.println("\n¡CASILLA NEGRA FINAL!");
                System.out.println("Responde correctamente esta pregunta final para ganar:");

                String colorPregunta = COLORES_PREGUNTAS[random.nextInt(COLORES_PREGUNTAS.length)];
                hacerPregunta(colorPregunta, jugador, true);
            } else {
                System.out.println("\nEstás en la casilla negra central pero aún no has completado todas las categorías.");
            }
        } else if (colorCasilla.equals(BLANCO)) {
            System.out.println("\n¡CASILLA BLANCA ESPECIAL!");
            String colorPregunta = COLORES_PREGUNTAS[random.nextInt(COLORES_PREGUNTAS.length)];
            System.out.println("Pregunta aleatoria de la categoría: " + colorPregunta);

            hacerPregunta(colorPregunta, jugador, false);

            if (jugador.getFicha().haCompletadoCategoria(colorPregunta)) {
                System.out.println("¡Respuesta correcta! Obtienes un lanzamiento de dado extra.");
                jugador.setPasosRestantes(Dado.lanzar());
                System.out.println("Tienes " + jugador.getPasosRestantes() + " movimientos adicionales.");
                return; // No cambies de jugador aún
            }
        } else if (!colorCasilla.trim().isEmpty() && !colorCasilla.equals(ROJO) && !colorCasilla.equals(MARRON)) {
            String nombreColor = obtenerNombreColor(colorCasilla);
            hacerPregunta(nombreColor, jugador, false);
        }

        // Verificar si ganó después de responder pregunta
        if (ficha.haGanado()) {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║ ¡FELICIDADES " + jugador.getNombre() + "! HAS GANADO EL JUEGO ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.exit(0);
        }
    }

    private void hacerPregunta(String colorCasilla, Jugador jugador, boolean esFinal) {
        Ficha ficha = jugador.getFicha();
        String categoria = ficha.obtenerCategoriaPorColor(colorCasilla);

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║         PREGUNTA DE " + categoria + " (" + colorCasilla + ")       ║");
        System.out.println("╠════════════════════════════════════════════╣");

        // Ejemplo de pregunta (en implementación real usarías una base de datos)
        System.out.println("Ejemplo de pregunta sobre " + categoria + ":");
        System.out.println("¿Cuál es la capital de Francia? (ejemplo)");
        System.out.print("Tu respuesta: ");
        String respuesta = scanner.nextLine();

        // Simulación de respuesta correcta/incorrecta
        boolean correcta = random.nextBoolean();

        if (correcta) {
            System.out.println("¡Respuesta correcta! Has completado " + categoria);
            ficha.marcarCategoriaCompletada(colorCasilla);

            if (esFinal) {
                System.out.println("\n╔════════════════════════════════════════════╗");
                System.out.println("║ ¡FELICIDADES " + jugador.getNombre() + "! HAS GANADO EL JUEGO ║");
                System.out.println("╚════════════════════════════════════════════╝");
                System.exit(0);
            }
        } else {
            System.out.println("Respuesta incorrecta. Sigue intentándolo.");
        }

        System.out.print("Presiona Enter para continuar...");
        scanner.nextLine();
    }

    private String obtenerNombreColor(String color) {
        if (color == null || color.trim().isEmpty()) return "VACÍO";
        if (color.equals(AZUL)) return "AZUL";
        if (color.equals(AMARILLO)) return "AMARILLO";
        if (color.equals(NARANJA)) return "NARANJA";
        if (color.equals(VERDE)) return "VERDE";
        if (color.equals(ROJO)) return "ROJO";
        if (color.equals(NEGRO)) return "NEGRO";
        if (color.equals(BLANCO)) return "BLANCO";
        if (color.equals(MARRON)) return "MARRON";
        return "DESCONOCIDO";
    }

    private void siguienteJugador() {
        jugadorActualIndex = (jugadorActualIndex + 1) % jugadores.size();
    }

    private void mostrarControles(Jugador jugador) {
        System.out.println("\nControles:");
        System.out.println("W: Arriba | S: Abajo | A: Izquierda | D: Derecha");
        System.out.println("Q: Diagonal ↖ | E: Diagonal ↗ | Z: Diagonal ↙ | C: Diagonal ↘");
        System.out.println("Pasos restantes: " + jugador.getPasosRestantes());

        // Mostrar progreso del jugador
        Ficha ficha = jugador.getFicha();
        System.out.println("\nProgreso:");
        System.out.println("🟦 Geografía: " + (ficha.haCompletadoCategoria("AZUL") ? "✅" : "❌"));
        System.out.println("🟨 Historia: " + (ficha.haCompletadoCategoria("AMARILLO") ? "✅" : "❌"));
        System.out.println("🟧 Deportes/Pasatiempos: " + (ficha.haCompletadoCategoria("NARANJA") ? "✅" : "❌"));
        System.out.println("🟩 Ciencias/Naturaleza: " + (ficha.haCompletadoCategoria("VERDE") ? "✅" : "❌"));
        System.out.println("🟪 Arte/Literatura: " + (ficha.haCompletadoCategoria("MORADO") ? "✅" : "❌"));
        System.out.println("🟤 Entretenimiento: " + (ficha.haCompletadoCategoria("ROSADO") ? "✅" : "❌"));
    }

    public void imprimirTablero() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                            TABLERO DE JUEGO                          ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");

        for (int i = 0; i < tablero.length; i++) {
            System.out.print("║");
            for (int j = 0; j < tablero[i].length; j++) {
                String celda = tablero[i][j].equals("") ? VACIO : tablero[i][j];
                System.out.print(celda);
            }
            System.out.println("║");
        }
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
    }
}