package archivo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class GuardadoPartida {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void guardar(Object datos, String ruta) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(ruta), datos);
            System.out.println("Partida guardada en: " + ruta);
        } catch (IOException e) {
            System.out.println("Error al guardar partida: " + e.getMessage());
        }
    }

    public static <T> T cargar(String ruta, Class<T> clase) {
        try {
            return mapper.readValue(new File(ruta), clase);
        } catch (IOException e) {
            System.out.println("Error al cargar partida: " + e.getMessage());
            return null;
        }
    }
}