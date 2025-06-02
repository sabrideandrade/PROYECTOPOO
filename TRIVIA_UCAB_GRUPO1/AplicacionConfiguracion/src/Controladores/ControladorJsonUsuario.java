// Archivo: Utilidades/ManejadorJsonUsuario.java
package Controladores;

import Modelos.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import Controladores.ControladorUsuario;

public class ControladorJsonUsuario {

    private static final String NOMBRE_ARCHIVO = "usuarios.json";

    public Usuario[] leerUsuariosDesdeJson() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(NOMBRE_ARCHIVO)) {
            Type usuarioArrayType = new TypeToken<Usuario[]>() {}.getType();
            Usuario[] usuariosLeidos = gson.fromJson(reader, usuarioArrayType);
            return usuariosLeidos != null ? usuariosLeidos : new Usuario[0];
        } catch (IOException e) {
            System.out.println("Archivo JSON no encontrado o error al leer. Creando uno nuevo si es necesario.");
            return new Usuario[0];
        }
    }

    public void escribirUsuariosAJson(Usuario[] usuarios) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(NOMBRE_ARCHIVO)) {
            gson.toJson(usuarios, writer);
            System.out.println("Usuarios guardados en " + NOMBRE_ARCHIVO + " correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir los usuarios en el archivo JSON: " + e.getMessage());
        }
    }
}
