

public class Movimiento {

    public static boolean esDireccionContraria(String nuevaDireccion, String ultimaDireccion) {
        if (ultimaDireccion == null) return false;
        switch (nuevaDireccion.toUpperCase()) {
            case "W": return ultimaDireccion.equalsIgnoreCase("S");
            case "S": return ultimaDireccion.equalsIgnoreCase("W");
            case "A": return ultimaDireccion.equalsIgnoreCase("D");
            case "D": return ultimaDireccion.equalsIgnoreCase("A");
            case "Q": return ultimaDireccion.equalsIgnoreCase("C");
            case "E": return ultimaDireccion.equalsIgnoreCase("Z");
            case "Z": return ultimaDireccion.equalsIgnoreCase("E");
            case "C": return ultimaDireccion.equalsIgnoreCase("Q");
            default: return false;
        }
    }

    public static boolean validarMovimiento(int nuevaFila, int nuevaColumna, String[][] tablero) {
        return !(nuevaFila < 0 || nuevaFila >= tablero.length ||
                nuevaColumna < 0 || nuevaColumna >= tablero[0].length ||
                tablero[nuevaFila][nuevaColumna].trim().isEmpty());
    }

    public static int[] calcularNuevaPosicion(int filaActual, int columnaActual, String direccion) {
        int nuevaFila = filaActual;
        int nuevaColumna = columnaActual;

        switch (direccion.toUpperCase()) {
            case "W": nuevaFila--; break;
            case "S": nuevaFila++; break;
            case "A": nuevaColumna--; break;
            case "D": nuevaColumna++; break;
            case "Q": nuevaFila--; nuevaColumna--; break;
            case "E": nuevaFila--; nuevaColumna++; break;
            case "Z": nuevaFila++; nuevaColumna--; break;
            case "C": nuevaFila++; nuevaColumna++; break;
        }

        return new int[]{nuevaFila, nuevaColumna};
    }
}

