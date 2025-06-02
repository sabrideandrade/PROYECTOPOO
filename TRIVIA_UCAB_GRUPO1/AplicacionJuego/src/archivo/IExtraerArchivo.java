package archivo;

import pregunta.PreguntaTexto;
import java.util.List;

public interface IExtraerArchivo {
    List<PreguntaTexto> extraerPreguntasPorCategoria(String categoria);
    void guardarPartida(String ruta, Object datos);
    <T> T cargarPartida(String ruta, Class<T> clase);
}
