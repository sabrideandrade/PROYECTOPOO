package Controladores;

import Modelos.Usuario;


public class ControladorUsuario {
    private static Usuario[] usuarios;
    private static int cantidadTotalUsuarios;
    private ControladorJsonUsuario manejadorJson; // Instancia del manejador JSON

    public static Usuario[] getUsuarios() {
        Usuario[] tempUsuarios = new Usuario[cantidadTotalUsuarios];
        for(int i = 0; i < cantidadTotalUsuarios; i++) {
            tempUsuarios[i] = usuarios[i];
        }
        return tempUsuarios;
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
        this.manejadorJson = new ControladorJsonUsuario(); // Inicializa el manejador JSON
        // Al iniciar el controlador, intenta cargar los usuarios desde el JSON
        Usuario[] usuariosCargados = manejadorJson.leerUsuariosDesdeJson();
        ControladorUsuario.setUsuarios(usuariosCargados);
        ControladorUsuario.setCantidadTotalUsuarios(usuariosCargados.length);
        System.out.println("Usuarios cargados desde JSON al iniciar: " + cantidadTotalUsuarios);
    }

    public void agregarUsuario(Usuario nuevoUsuario) {
        if (cantidadTotalUsuarios == usuarios.length) {
            int nuevaCapacidad = (usuarios.length == 0) ? 1 : usuarios.length * 2;
            Usuario[] nuevoArreglo = new Usuario[nuevaCapacidad];
            for (int i = 0; i < usuarios.length; i++) {
                nuevoArreglo[i] = usuarios[i];
            }
            usuarios = nuevoArreglo;
        }
        usuarios[cantidadTotalUsuarios] = nuevoUsuario;
        cantidadTotalUsuarios++;
        guardarUsuariosEnJson();
    }


    private void guardarUsuariosEnJson() {
        manejadorJson.escribirUsuariosAJson(ControladorUsuario.getUsuarios());
    }

    public void mostrarUsuarios() {
        if (cantidadTotalUsuarios == 0) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        for (int i = 0; i < cantidadTotalUsuarios; i++) {
            System.out.println("--- Usuario " + (i + 1) + " ---");
            System.out.println("Nombre: " + usuarios[i].getNombreUsuario());
            System.out.println("Apellido: " + usuarios[i].getApellidoUsuario());
            System.out.println("Correo: " + usuarios[i].getCorreoUsuario());
            System.out.println("Contraseña: " + usuarios[i].getContrasenausuario());
            System.out.println("Rol: " + usuarios[i].getRolUsuario());
        }
    }

    public Usuario crearUsuario(String nombre, String apellido, String correo, String contrasena, String rol) {
        return new Usuario(nombre, apellido, correo, rol , contrasena);
    }

    public Usuario buscarUsuarioCorreo(String correo) {
        for (int i = 0; i < cantidadTotalUsuarios; i++) {
            if (usuarios[i].getCorreoUsuario().equals(correo)) {
                return usuarios[i];
            }
        }
        return null;
    }
}
