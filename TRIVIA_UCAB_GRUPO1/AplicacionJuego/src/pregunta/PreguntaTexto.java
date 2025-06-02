package pregunta;

public class PreguntaTexto {
    private String pregunta;
    private String respuesta;

    // Constructor sin argumentos
    public PreguntaTexto() {}

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

    public boolean esCorrecta(String input) {
        return limpiar(input).equals(limpiar(respuesta));
    }

    private String limpiar(String texto) {
        return texto.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace(" ", "")
                .replace("á", "a")
                .replace("é", "e")
                .replace("í", "i")
                .replace("ó", "o")
                .replace("ú", "u")
                .replace("ü", "u")
                .trim();
    }
}