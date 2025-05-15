package Vistas;

import Controladores.ControladorUsuario;
import Modelos.Usuario;

import java.util.Scanner;

public class VistasUsuarios {
    private final ControladorUsuario controladorUsuario;

    public VistasUsuarios() {
        this.controladorUsuario = new ControladorUsuario();
    }

    public void agregarUsuario() {
        System.out.println("Ingrese el nombre del usuario: ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        System.out.println("Ingrese el apellido del usuario: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese el correo del usuario: ");
        String correo = sc.nextLine();
        System.out.println("Ingrese la contraseña del usuario: ");
        String contrasena = sc.nextLine();
        String rol = "Jugador";
        Usuario nuevoUsuario = controladorUsuario.crearUsuario(nombre, apellido, correo, contrasena, rol);
        controladorUsuario.agregarUsuario(nuevoUsuario);
        controladorUsuario.mostrarUsuarios();

    }

    public void listarUsuarios() {
        Usuario[] usuarios = controladorUsuario.getUsuarios();
            for (int i = 0; i < usuarios.length; i++) {
                System.out.println(usuarios[i].getNombreUsuario());
                System.out.println(usuarios[i].getApellidoUsuario());
                System.out.println(usuarios[i].getCorreoUsuario());
                System.out.println(usuarios[i].getContrasenausuario());
            }
    }
}
