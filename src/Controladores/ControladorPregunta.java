package Controladores;

import Modelos.Pregunta;


public class ControladorPregunta {
    private static Pregunta[] preguntas;
    private int totalPreguntas;

    public ControladorPregunta() {
        this.totalPreguntas = 0;
        preguntas = new Pregunta[0];
    }

    public Pregunta[] getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Pregunta[] preguntas) {
        this.preguntas = preguntas;
    }

    public int getTotalPreguntas() {
        return totalPreguntas;
    }

    public void setTotalPreguntas(int totalPreguntas) {
        this.totalPreguntas = totalPreguntas;
    }

    public Pregunta crearPregunta(String pregunta, String respuesta, String estado, String correoPregunta, String creadorPregunta, boolean apruebaPregunta, int idPregunta) {
        return new Pregunta(pregunta,respuesta,estado,correoPregunta,creadorPregunta,apruebaPregunta,idPregunta);
    }

    public void agregarPregunta(Pregunta nuevoPregunta) {
        Pregunta[] nuevoArreglo = new Pregunta[preguntas.length + 1];
        for (int i = 0; i < preguntas.length; i++) {
            nuevoArreglo[i] = preguntas[i];
        }
        preguntas = nuevoArreglo;
        preguntas[totalPreguntas] = nuevoPregunta;
        totalPreguntas++;
    }

    public void modificarPregunta(Pregunta nuevoPregunta, Pregunta pregunta) {
        pregunta.setPregunta(nuevoPregunta.getPregunta());
        pregunta.setRespuesta(nuevoPregunta.getRespuesta());
    }

    public Pregunta consultarPregunta(int idPregunta) {
        for (int i = 0; i < totalPreguntas; i++) {
            if (preguntas[i].getIdPregunta() == idPregunta) {
                return preguntas[i];
            }
        }
        return null;
    }

    public void eliminarPregunta(int idPregunta) {
        int indiceEliminar = -1;
        for (int i = 0; i < totalPreguntas; i++) {
            if (preguntas[i].getIdPregunta() == idPregunta) {
                indiceEliminar = i;
                break;
            }
        }

        if (indiceEliminar != -1) {
            Pregunta[] nuevoArreglo = new Pregunta[totalPreguntas - 1];
            int indiceNuevoArreglo = 0;

            for (int i = 0; i < totalPreguntas; i++) {
                if (i != indiceEliminar) {
                    nuevoArreglo[indiceNuevoArreglo] = preguntas[i];
                    indiceNuevoArreglo++;
                }
            }

            preguntas = nuevoArreglo;
            totalPreguntas--;
            System.out.println("Pregunta con ID " + idPregunta + " eliminada correctamente.");
        } else {
            System.out.println("No se encontró ninguna pregunta con el ID: " + idPregunta);
        }
    }

    public void aprobarPregunta(int idPregunta, String correoPregunta) {
        for (int i = 0; i < totalPreguntas; i++) {
            if (preguntas[i].getIdPregunta() == idPregunta) {
                preguntas[i].setCorreoPregunta(correoPregunta);
                preguntas[i].setApruebaPregunta(true);
                System.out.println("Pregunta con ID " + idPregunta + " ha sido aprobada.");
                return;
            }
        }
        System.out.println("No se encontró ninguna pregunta con el ID: " + idPregunta);
    }
}
