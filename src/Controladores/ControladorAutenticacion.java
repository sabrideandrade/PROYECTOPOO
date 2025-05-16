package Controladores;

import Modelos.Usuario;

import java.util.Objects;

public class ControladorAutenticacion {
    public boolean login(String correoUsuario, String contrasenaCorrectaUsuario, Usuario usuario) {
        if (Objects.equals(usuario.getCorreoUsuario(), correoUsuario) && Objects.equals(usuario.getContrasenausuario(), contrasenaCorrectaUsuario)) {
            return true;
        }
        else {
            return false;
        }
    }
}
