package archivo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pregunta.PreguntaTexto;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class ExtraerArchivo implements IExtraerArchivo {
    private final Map<String, List<PreguntaTexto>> preguntasPorCategoria = new HashMap<>();
    private static final Gson gson = new Gson();

    public ExtraerArchivo(String rutaJSON) {
        try (FileReader reader = new FileReader(rutaJSON)) {
            Type type = new TypeToken<Map<String, List<PreguntaTexto>>>() {}.getType();
            Map<String, List<PreguntaTexto>> data = gson.fromJson(reader, type);
            if (data != null) {
                for (Map.Entry<String, List<PreguntaTexto>> entry : data.entrySet()) {
                    preguntasPorCategoria.put(entry.getKey().toLowerCase(), entry.getValue());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer preguntas: " + e.getMessage());
        }
    }


    public List<PreguntaTexto> extraerPreguntasPorCategoria(String categoria) {
        return preguntasPorCategoria.getOrDefault(categoria.toLowerCase(), new ArrayList<>());
    }

    public void guardarPartida(String ruta, Object datos) {
        GuardadoPartidaGson.guardar(datos, ruta);
    }

    public <T> T cargarPartida(String ruta, Class<T> clase) {
        return GuardadoPartidaGson.cargar(ruta, clase);
    }
}