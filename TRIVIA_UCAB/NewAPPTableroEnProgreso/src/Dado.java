import java.util.Random;
import java.util.Collections;
import java.util.List;

public class Dado {

    private static final Random random = new Random();

    public static int lanzar() {
        return random.nextInt(6) + 1;
    }

    public static List<Jugador> determinarOrdenJugadores(List<Jugador> jugadores) {
        System.out.println("\n=== Determinando orden de jugadores ===");
        for (Jugador jugador : jugadores) {
            int tirada = lanzar();
            jugador.setTiradaInicial(tirada);
            System.out.println(jugador.getNombre() + " tiró: " + tirada);
        }

        Collections.sort(jugadores, (j1, j2) -> Integer.compare(j2.getTiradaInicial(), j1.getTiradaInicial()));

        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).getFicha().setTurno(i + 1);
            System.out.println((i + 1) + ". " + jugadores.get(i).getNombre());
        }

        return jugadores;
    }
}

