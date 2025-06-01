package core;

public class Cronometro {
    private long inicio;
    private long fin;

    public void iniciar() {
        inicio = System.currentTimeMillis();
    }

    public void detener() {
        fin = System.currentTimeMillis();
    }

    public int obtenerSegundosTranscurridos() {
        return (int) ((fin - inicio) / 1000);
    }
}
