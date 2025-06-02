package Vistas;

import Controladores.ControladorAutenticacion;
import Controladores.ControladorUsuario;
import Modelos.Usuario;

import java.util.Scanner;


public class VistasAutenticacion {
    private final ControladorAutenticacion controladorAutenticacion;
    private final ControladorUsuario controladorUsuario;

    public VistasAutenticacion() {
        this.controladorUsuario = new ControladorUsuario();
        this.controladorAutenticacion = new ControladorAutenticacion();
    }

    public void login() {
        System.out.println("Ingrese su correo: ");
        Scanner sc = new Scanner(System.in);
        String correo = sc.nextLine();
        System.out.println("Ingrese su contrasena: ");
        String contrasena = sc.nextLine();
        Usuario usuario = controladorUsuario.buscarUsuarioCorreo(correo);
        if (usuario == null) {
            System.out.println("Usuario no encontrado");
        }
        else {
            if (controladorAutenticacion.login(correo, contrasena, usuario)) {
                System.out.println("Iniciar sesion exitosa");
            }
            else {
                System.out.println("Hubo un error al iniciar sesion");
                System.out.println("Datos ingresados incorrectos");
            }
        }

    }
}
