package archivo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GuardadoPartidaGson {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void guardar(Object datos, String ruta) {
        try (FileWriter writer = new FileWriter(ruta)) {
            gson.toJson(datos, writer);
            System.out.println("Partida guardada en: " + ruta);
        } catch (IOException e) {
            System.out.println("Error al guardar partida: " + e.getMessage());
        }
    }

    public static <T> T cargar(String ruta, Class<T> clase) {
        try (FileReader reader = new FileReader(ruta)) {
            return gson.fromJson(reader, clase);
        } catch (IOException e) {
            System.out.println("Error al cargar partida: " + e.getMessage());
            return null;
        }
    }
}
