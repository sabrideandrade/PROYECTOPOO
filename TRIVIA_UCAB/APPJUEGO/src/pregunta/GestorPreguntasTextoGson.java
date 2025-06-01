package pregunta;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;

public class GestorPreguntasTextoGson {
    private final Map<String, List<PreguntaTexto>> preguntasPorCategoria = new HashMap<>();
    private final Map<String, Integer> indices = new HashMap<>();

    public GestorPreguntasTextoGson(String rutaArchivo) {
        try (FileReader reader = new FileReader(rutaArchivo)) {
            Gson gson = new Gson();
            Type tipoMapa = new TypeToken<Map<String, List<PreguntaTexto>>>(){}.getType();
            Map<String, List<PreguntaTexto>> data = gson.fromJson(reader, tipoMapa);

            for (String categoria : data.keySet()) {
                preguntasPorCategoria.put(categoria.toLowerCase(), data.get(categoria));
                indices.put(categoria.toLowerCase(), 0);
            }
        } catch (Exception e) {
            System.out.println("Error cargando preguntas con GSON: " + e.getMessage());
        }
    }

    public PreguntaTexto siguiente(String categoria) {
        categoria = categoria.toLowerCase();
        List<PreguntaTexto> lista = preguntasPorCategoria.get(categoria);
        if (lista == null || lista.isEmpty()) return null;
        int i = indices.getOrDefault(categoria, 0);
        PreguntaTexto p = lista.get(i);
        indices.put(categoria, (i + 1) % lista.size());
        return p;
    }
}
