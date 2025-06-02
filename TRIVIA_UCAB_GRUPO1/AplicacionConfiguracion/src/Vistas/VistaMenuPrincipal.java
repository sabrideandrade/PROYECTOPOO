package Vistas;

import Controladores.ControladorAutenticacion;
import Controladores.ControladorPregunta;
import Controladores.ControladorUsuario;
import Modelos.Usuario;

import java.util.Scanner;

public class VistaMenuPrincipal {
    private final VistasUsuarios vistasUsuarios;
    private final VistasAutenticacion vistasAutenticacion;
    private final VistasPreguntas vistasPreguntas;
    private final ControladorUsuario controladorUsuario;
    private final ControladorAutenticacion controladorAutenticacion;

    private Usuario usuarioLogueado;

    public VistaMenuPrincipal() {
        ControladorPregunta controladorPregunta = new ControladorPregunta();
        this.vistasUsuarios = new VistasUsuarios();
        this.vistasAutenticacion = new VistasAutenticacion();
        this.vistasPreguntas = new VistasPreguntas();
        this.controladorUsuario = new ControladorUsuario();
        this.controladorAutenticacion = new ControladorAutenticacion();
        this.usuarioLogueado = null;
    }

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("========== MENÚ PRINCIPAL ==========");
            if (usuarioLogueado == null) {
                System.out.println("1. Iniciar usuario");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese su correo: ");
                        String correo = sc.nextLine();
                        System.out.println("Ingrese su contraseña: ");
                        String contrasena = sc.nextLine();
                        Usuario usuario = controladorUsuario.buscarUsuarioCorreo(correo);
                        if (usuario == null) {
                            System.out.println("Usuario no encontrado.");
                        } else {
                            if (controladorAutenticacion.login(correo, contrasena, usuario)) {
                                usuarioLogueado = usuario;
                                System.out.println("Inicio de sesión exitoso.");
                            } else {
                                System.out.println("Credenciales incorrectas.");
                            }
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            } else {
                // Menú para usuarios autenticados
                System.out.println("Bienvenido, " + usuarioLogueado.getNombreUsuario());
                System.out.println("1. Listar usuarios");
                System.out.println("2. Agregar pregunta");
                System.out.println("3. Mostrar preguntas");
                System.out.println("4. Modificar pregunta");
                System.out.println("5. Consultar pregunta");
                System.out.println("6. Eliminar pregunta");
                System.out.println("7. Aprobar pregunta");
                System.out.println("8. Cerrar sesión");
                System.out.println("9. Crear usuario");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        vistasUsuarios.listarUsuarios();
                        break;
                    case 2:
                        vistasPreguntas.agregarPregunta();
                        break;
                    case 3:
                        vistasPreguntas.mostrarPregunta();
                        break;
                    case 4:
                        vistasPreguntas.modificarPregunta();
                        break;
                    case 5:
                        vistasPreguntas.consultarPregunta();
                        break;
                    case 6:
                        vistasPreguntas.eliminarPregunta();
                        break;
                    case 7:
                        vistasPreguntas.aprobarPregunta();
                        break;
                    case 8:
                        usuarioLogueado = null;
                        System.out.println("Sesión cerrada correctamente.");
                        break;
                    case 9:
                        vistasUsuarios.agregarUsuario();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            }

            System.out.println();
        } while (opcion != 0);
    }
}
