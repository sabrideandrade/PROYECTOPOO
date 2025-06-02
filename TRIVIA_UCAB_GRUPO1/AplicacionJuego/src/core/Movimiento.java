package core;

import modelo.Usuario;
import tablero.Tablero;

public class Movimiento {

    public static void moverUsuario(Usuario usuario, int pasos, Tablero tablero) {
        int nuevaPosicion = (usuario.getPosicion() + pasos) % 73;
        usuario.setPosicion(nuevaPosicion);
        tablero.colocarFichaEn(nuevaPosicion);
    }

    public static boolean puedeEntrarAlCentro(Usuario usuario, int pasos) {
        return usuario.getFicha().todasCompletadas() &&
                (usuario.getPosicion() + pasos) % 73 == 72;
    }

    public static void irAlCentro(Usuario usuario) {
        usuario.setPosicion(72);
    }
}
