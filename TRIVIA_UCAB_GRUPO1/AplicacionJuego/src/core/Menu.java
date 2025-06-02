package core;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public boolean mostrarMenuPrincipal() {
        System.out.println("\n=== BIENVENIDO A TRIVIA-UCAB ===");
        System.out.println("1. Nueva Partida");
        System.out.println("2. Cargar Partida");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");

        int opcion = Integer.parseInt(scanner.nextLine());
        return opcion == 1;
    }

    public void mostrarDespedida() {
        System.out.println("\n¡Gracias por jugar TRIVIA UCAB!");
    }
}
