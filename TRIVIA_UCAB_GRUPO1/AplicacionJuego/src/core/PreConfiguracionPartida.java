package core;

import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PreConfiguracionPartida {
    private final Scanner scanner = new Scanner(System.in);
    private boolean juegoPorTiempo;
    private String dificultad;
    private final List<Usuario> jugadores = new ArrayList<>();

    public void configurar() {
        System.out.println("\n=== CONFIGURACION DE PARTIDA ===");

        System.out.print("¿Desean jugar con tiempo por pregunta? (s/n): ");
        juegoPorTiempo = scanner.nextLine().trim().equalsIgnoreCase("s");

        System.out.print("Dificultad ('f' para Fácil): ");
        dificultad = scanner.nextLine().trim().equalsIgnoreCase("f") ? "facil" : "facil";

        int cantidad;
        do {
            System.out.print("Numero de jugadores (1-6): ");
            cantidad = Integer.parseInt(scanner.nextLine());
        } while (cantidad < 1 || cantidad > 6);

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Correo del jugador " + (i + 1) + ": ");
            jugadores.add(new Usuario(scanner.nextLine()));
        }
    }

    public boolean esPorTiempo() {
        return juegoPorTiempo;
    }

    public String getDificultad() {
        return dificultad;
    }

    public List<Usuario> getJugadores() {
        return jugadores;
    }
}
