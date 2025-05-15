import Controladores.ControladorUsuario;
import Vistas.VistasAutenticacion;
import Vistas.VistasUsuarios;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        VistasUsuarios vistasUsuarios = new VistasUsuarios();
        vistasUsuarios.agregarUsuario();
        //vistasUsuarios.agregarUsuario();
        VistasAutenticacion vistasAutenticacion = new VistasAutenticacion();
        vistasAutenticacion.login();
        vistasAutenticacion.login();
    }
}