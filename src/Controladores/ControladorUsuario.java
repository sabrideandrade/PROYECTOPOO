package Controladores;

import Modelos.Usuario;

public class ControladorUsuario {
    private static Usuario[] usuarios;
    private static int cantidadTotalUsuarios;

    public static Usuario[] getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(Usuario[] usuarios) {
        ControladorUsuario.usuarios = usuarios;
    }

    public static int getCantidadTotalUsuarios() {
        return cantidadTotalUsuarios;
    }

    public static void setCantidadTotalUsuarios(int cantidadTotalUsuarios) {
        ControladorUsuario.cantidadTotalUsuarios = cantidadTotalUsuarios;
    }

    public ControladorUsuario() {
        cantidadTotalUsuarios = 0;
        usuarios = new Usuario[0];
    }

    public void agregarUsuario(Usuario nuevoUsuario) {
            Usuario[] nuevoArreglo = new Usuario[usuarios.length + 1];
            for (int i = 0; i < usuarios.length; i++) {
                nuevoArreglo[i] = usuarios[i];
            }
            usuarios = nuevoArreglo;
        usuarios[cantidadTotalUsuarios] = nuevoUsuario;
        cantidadTotalUsuarios++;
    }

    public void mostrarUsuarios() {
        for (int i = 0; i < usuarios.length; i++) {
            System.out.println(usuarios[i].getNombreUsuario());
            System.out.println(usuarios[i].getApellidoUsuario());
            System.out.println(usuarios[i].getCorreoUsuario());
            System.out.println(usuarios[i].getContrasenausuario());
        }
    }

    public Usuario crearUsuario(String nombre, String apellido, String correo, String contrasena, String rol) {
        return new Usuario(nombre, apellido, correo, rol , contrasena);
    }

    public Usuario buscarUsuarioCorreo(String correo) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].getCorreoUsuario().equals(correo)) {
                return usuarios[i];
            }
        }
        return null;
    }
}
