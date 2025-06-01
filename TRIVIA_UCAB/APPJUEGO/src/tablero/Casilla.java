package tablero;

public class Casilla {
    private String categoria;
    private boolean especial;
    private boolean tieneFicha;

    public Casilla(String categoria, boolean especial) {
        this.categoria = categoria;
        this.especial = especial;
        this.tieneFicha = false;
    }

    public void colocarFicha() {
        this.tieneFicha = true;
    }

    public void quitarFicha() {
        this.tieneFicha = false;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean esEspecial() {
        return especial;
    }

    public String toString() {
        if (tieneFicha) {
            return "[ * ]";
        }
        switch (categoria) {
            case "geo": return "[AZU]";
            case "his": return "[AMA]";
            case "dep": return "[NAR]";
            case "cie": return "[VER]";
            case "art": return "[MOR]";
            case "ent": return "[ROS]";
            case "esp": return "[ESP]";
            case "cent": return "[CENT]";
            default: return "[???]";
        }
    }
}
