package modelo;

import java.util.HashMap;
import java.util.Map;

public class Estadistica {
    private int juegosGanados;
    private int tiempoTotal;
    private Map<String, Integer> correctasPorCategoria;

    public Estadistica() {
        this.correctasPorCategoria = new HashMap<>();
        for (String cat : new String[]{"geo", "his", "dep", "cie", "art", "ent"}) {
            correctasPorCategoria.put(cat, 0);
        }
    }

    public void sumarCorrecta(String categoria) {
        correctasPorCategoria.put(categoria,
                correctasPorCategoria.getOrDefault(categoria, 0) + 1);
    }

    public void agregarTiempo(int segundos) {
        tiempoTotal += segundos;
    }

    public void sumarJuegoGanado() {
        juegosGanados++;
    }

    public int getJuegosGanados() {
        return juegosGanados;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public Map<String, Integer> getCorrectasPorCategoria() {
        return correctasPorCategoria;
    }
}
