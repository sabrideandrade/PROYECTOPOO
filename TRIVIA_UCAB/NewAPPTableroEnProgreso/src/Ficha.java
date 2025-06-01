public class Ficha {
    private String simbolo;
    private int[] posicion;
    private int turno;
    private String contenidoAnterior;
    private boolean geografiaAzul;
    private boolean historiaAmarillo;
    private boolean deportesPasatiemposNaranja;
    private boolean cienciasNaturalezaVerde;
    private boolean arteLiteraturaMorado;
    private boolean entretenimientoRosado;
    private String ultimaDireccion;

    public Ficha(String simbolo, int turno, int filaInicial, int columnaInicial) {
        this.simbolo = simbolo;
        this.turno = turno;
        this.posicion = new int[]{filaInicial, columnaInicial};
        this.contenidoAnterior = "  ";
        resetearCategorias();
    }

    private void resetearCategorias() {
        geografiaAzul = false;
        historiaAmarillo = false;
        deportesPasatiemposNaranja = false;
        cienciasNaturalezaVerde = false;
        arteLiteraturaMorado = false;
        entretenimientoRosado = false;
    }

    public boolean haCompletadoTodasLasCategorias() {
        return geografiaAzul && historiaAmarillo && deportesPasatiemposNaranja &&
                cienciasNaturalezaVerde && arteLiteraturaMorado && entretenimientoRosado;
    }

    // Getters y Setters existentes
    public String getSimbolo() { return simbolo; }
    public int[] getPosicion() { return posicion; }
    public int getTurno() { return turno; }
    public void setTurno(int turno) { this.turno = turno; }
    public String getContenidoAnterior() { return contenidoAnterior; }
    public void setContenidoAnterior(String contenido) { this.contenidoAnterior = contenido; }
    public String getUltimaDireccion() { return ultimaDireccion; }
    public void setUltimaDireccion(String direccion) { this.ultimaDireccion = direccion; }

    public boolean haCompletadoCategoria(String color) {
        switch (color.toUpperCase()) {
            case "AZUL": return geografiaAzul;
            case "AMARILLO": return historiaAmarillo;
            case "NARANJA": return deportesPasatiemposNaranja;
            case "VERDE": return cienciasNaturalezaVerde;
            case "MORADO": return arteLiteraturaMorado;
            case "ROSADO": return entretenimientoRosado;
            default: return false;
        }
    }

    public void marcarCategoriaCompletada(String color) {
        switch (color.toUpperCase()) {
            case "AZUL": geografiaAzul = true; break;
            case "AMARILLO": historiaAmarillo = true; break;
            case "NARANJA": deportesPasatiemposNaranja = true; break;
            case "VERDE": cienciasNaturalezaVerde = true; break;
            case "MORADO": arteLiteraturaMorado = true; break;
            case "ROSADO": entretenimientoRosado = true; break;
        }
    }

    public String obtenerCategoriaPorColor(String color) {
        switch (color.toUpperCase()) {
            case "AZUL": return "GEOGRAFÍA";
            case "AMARILLO": return "HISTORIA";
            case "NARANJA": return "DEPORTES/PASATIEMPOS";
            case "VERDE": return "CIENCIAS/NATURALEZA";
            case "MORADO": return "ARTE/LITERATURA";
            case "ROSADO": return "ENTRETENIMIENTO";
            default: return "ESPECIAL";
        }
    }

    public boolean haGanado() {
        return haCompletadoTodasLasCategorias();
    }
}

