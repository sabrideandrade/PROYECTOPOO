package Vistas;

import java.util.Scanner;

public class VistaMenuPrincipal {
    private final VistasUsuarios vistasUsuarios;
    private final VistasAutenticacion vistasAutenticacion;
    private final VistasPreguntas vistasPreguntas;

    public VistaMenuPrincipal() {
        this.vistasUsuarios = new VistasUsuarios();
        this.vistasAutenticacion = new VistasAutenticacion();
        this.vistasPreguntas = new VistasPreguntas();
    }

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("========== MENÚ PRINCIPAL ==========");
            System.out.println("1. Crear un usuario");
            System.out.println("2. Listar los usuarios");
            System.out.println("3. Iniciar sesión");
            System.out.println("4. Agregar las pregunta");
            System.out.println("5. Mostrar las preguntas");
            System.out.println("6. Modificar una pregunta");
            System.out.println("7. Consultar la pregunta");
            System.out.println("8. Eliminar una pregunta");
            System.out.println("9. Aprobar la pregunta");
            System.out.println("10. Salir del programa");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    vistasUsuarios.agregarUsuario();
                    break;
                case 2:
                    vistasUsuarios.listarUsuarios();
                    break;
                case 3:
                    vistasAutenticacion.login();
                    break;
                case 4:
                    vistasPreguntas.agregarPregunta();
                    break;
                case 5:
                    vistasPreguntas.mostrarPregunta();
                    break;
                case 6:
                    vistasPreguntas.modificarPregunta();
                    break;
                case 7:
                    vistasPreguntas.consultarPregunta();
                    break;
                case 8:
                    vistasPreguntas.eliminarPregunta();
                    break;
                case 9:
                    vistasPreguntas.aprobarPregunta();
                    break;
                case 10:
                    System.out.println("Salir del sistema.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            System.out.println();
        } while (opcion != 0);
    }

    public static void main(String[] args) {
        VistaMenuPrincipal menu = new VistaMenuPrincipal();
        menu.mostrarMenu();
    }
}