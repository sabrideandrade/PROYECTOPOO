import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private Ficha ficha;
    private int tiradaInicial;
    private int pasosRestantes;
    private List<String> historialMovimientos;

    public Jugador(String nombre, String simboloFicha, int filaInicial, int columnaInicial) {
        this.nombre = nombre;
        this.ficha = new Ficha(simboloFicha, 0, filaInicial, columnaInicial);
        this.pasosRestantes = 0;
        this.historialMovimientos = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public Ficha getFicha() { return ficha; }
    public int getTiradaInicial() { return tiradaInicial; }
    public void setTiradaInicial(int tirada) { this.tiradaInicial = tirada; }
    public int getPasosRestantes() { return pasosRestantes; }
    public void setPasosRestantes(int pasos) { this.pasosRestantes = pasos; }
    public List<String> getHistorialMovimientos() { return historialMovimientos; }

    public void agregarMovimiento(String direccion) {
        historialMovimientos.add(direccion);
        ficha.setUltimaDireccion(direccion);
    }
}
