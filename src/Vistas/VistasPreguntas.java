package Vistas;

import Controladores.ControladorPregunta;
import Modelos.Pregunta;


import java.util.Scanner;

public class VistasPreguntas {
    private final ControladorPregunta controladorPregunta;

    public VistasPreguntas(ControladorPregunta controladorPregunta) {
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
}
