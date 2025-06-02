package Controladores;

import Modelos.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Objects;

public class ControladorAutenticacion {
    public boolean login(String correoUsuario, String contrasenaCorrectaUsuario, Usuario usuario) {
        if (Objects.equals(usuario.getCorreoUsuario(), correoUsuario) && verificarContrasena(contrasenaCorrectaUsuario,usuario.getContrasenausuario()) && usuario.getRolUsuario().equals("admin")) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean verificarContrasena(String contrasenaPlana, String contrasenaHasheadaAlmacenada) {
        return BCrypt.checkpw(contrasenaPlana, contrasenaHasheadaAlmacenada);
    }
}
