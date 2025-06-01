package modelo;

public class Usuario {
    private String correo;
    private Ficha ficha;
    private int posicion; 
    private boolean enCentro;
    private Estadistica estadistica;

    public Usuario(String correo) {
        this.correo = correo;
        this.ficha = new Ficha();
        this.posicion = 72; 
        this.enCentro = true;
        this.estadistica = new Estadistica();
    }

    public String getCorreo() { return correo; }

    public Ficha getFicha() { return ficha; }

    public int getPosicion() { return posicion; }

    public void setPosicion(int pos) {
        this.posicion = pos;
        this.enCentro = (pos == 72);
    }

    public boolean estaEnCentro() { return enCentro; }

    public Estadistica getEstadistica() { return estadistica; }
}
