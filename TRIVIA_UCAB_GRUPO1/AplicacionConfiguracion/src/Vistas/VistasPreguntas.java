package Vistas;

import Controladores.ControladorPregunta;
import Modelos.Pregunta;


import java.util.Scanner;

public class VistasPreguntas {
    private final ControladorPregunta controladorPregunta;

    public VistasPreguntas() {
        this.controladorPregunta = new ControladorPregunta();
    }

    public void agregarPregunta() {
        System.out.println("Ingrese una pregunta: ");
        Scanner sc = new Scanner(System.in);
        String pregunta = sc.nextLine();
        System.out.println("Ingrese la respuesta: ");
        String respuesta = sc.nextLine();
        System.out.println("Ingrese el correo del creador: ");
        String creador = sc.nextLine();
        String estado = "esperando aprobacion";
        System.out.println("Ingrese el ID: ");
        int id = sc.nextInt();
        boolean aprueba = false;
        Pregunta pregunta1 = new Pregunta(pregunta,respuesta, estado,null,creador,aprueba,id);
        controladorPregunta.agregarPregunta(pregunta1);
    }

    public void mostrarPregunta() {
        Pregunta[] preguntas = controladorPregunta.getPreguntas();
        for (int i = 0; i < preguntas.length; i++) {
            System.out.println(preguntas[i].getPregunta());
            System.out.println(preguntas[i].getRespuesta());
            System.out.println(preguntas[i].getCorreoPregunta());
            System.out.println(preguntas[i].getEstado());
            System.out.println(preguntas[i].getCreadorPregunta());
            System.out.println(preguntas[i].getApruebaPregunta());
            System.out.println(preguntas[i].getIdPregunta());
        }
    }

    public void modificarPregunta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID de la pregunta a modificar: ");
        int id = sc.nextInt();
        sc.nextLine();
        Pregunta preguntaExistente = controladorPregunta.consultarPregunta(id);

        if (preguntaExistente != null) {
            System.out.println("Ingrese la nueva pregunta: ");
            String nuevaPregunta = sc.nextLine();
            System.out.println("Ingrese la nueva respuesta: ");
            String nuevaRespuesta = sc.nextLine();

            Pregunta nueva = new Pregunta(nuevaPregunta, nuevaRespuesta, preguntaExistente.getEstado(), preguntaExistente.getCorreoPregunta(), preguntaExistente.getCreadorPregunta(), preguntaExistente.getApruebaPregunta(), id);

            controladorPregunta.modificarPregunta(nueva, preguntaExistente);
            System.out.println("Pregunta modificada correctamente.");
        } else {
            System.out.println("No se encontró una pregunta con ese ID.");
        }
    }

    public void consultarPregunta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID de la pregunta a consultar: ");
        int id = sc.nextInt();
        Pregunta pregunta = controladorPregunta.consultarPregunta(id);

        if (pregunta != null) {
            System.out.println("La pregunta es: " + pregunta.getPregunta());
            System.out.println("La respuesta es: " + pregunta.getRespuesta());
            System.out.println("El estado es: " + pregunta.getEstado());
            System.out.println("El correo es: " + pregunta.getCorreoPregunta());
            System.out.println("El creador es: " + pregunta.getCreadorPregunta());
            System.out.println("Su Aprobacion: " + pregunta.getApruebaPregunta());
            System.out.println("El ID: " + pregunta.getIdPregunta());
        } else {
            System.out.println("No se encontró una pregunta con ese ID.");
        }
    }

    public void eliminarPregunta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID de la pregunta a eliminar: ");
        int id = sc.nextInt();
        controladorPregunta.eliminarPregunta(id);
    }

    public void aprobarPregunta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID de la pregunta a aprobar: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el correo del aprobador: ");
        String correo = sc.nextLine();
        controladorPregunta.aprobarPregunta(id, correo);
    }
}
