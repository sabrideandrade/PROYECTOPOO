package Modelos;

public class Usuario {
    private String nombreUsuario;
    private String apellidoUsuario;
    private String correoUsuario;
    private String rolUsuario;
    private String contrasenausuario;

    public String getContrasenausuario() {
        return contrasenausuario;
    }

    public void setContrasenausuario(String contrasenausuario) {
        this.contrasenausuario = contrasenausuario;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public Usuario(String nombreUsuario, String apellidoUsuario, String correoUsuario, String rolUsuario, String contrasenausuario) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.rolUsuario = rolUsuario;
        this.contrasenausuario = contrasenausuario;
    }

    void registrarUsuario() {
        System.out.println("Modelos.Usuario registrado correctamente");
    }
}
