package Modelos;

public class Pregunta {
    public static int length;
    private String pregunta;
    private String respuesta;
    private String estado;
    private String correoPregunta;
    private String creadorPregunta;
    private boolean apruebaPregunta;
    private int idPregunta;

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCorreoPregunta() {
        return correoPregunta;
    }

    public void setCorreoPregunta(String correoPregunta) {
        this.correoPregunta = correoPregunta;
    }

    public String getCreadorPregunta() {
        return creadorPregunta;
    }

    public void setCreadorPregunta(String creadorPregunta) {
        this.creadorPregunta = creadorPregunta;
    }

    public boolean getApruebaPregunta() {
        return apruebaPregunta;
    }

    public void setApruebaPregunta(boolean apruebaPregunta) {
        this.apruebaPregunta = apruebaPregunta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Pregunta(String pregunta, String respuesta, String estado, String correoPregunta, String creadorPregunta, boolean apruebaPregunta, int idPregunta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.estado = estado;
        this.correoPregunta = correoPregunta;
        this.creadorPregunta = creadorPregunta;
        this.apruebaPregunta = apruebaPregunta;
        this.idPregunta = idPregunta;
    }
}
