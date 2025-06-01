package modelo;

import java.util.HashSet;
import java.util.Set;

public class Ficha {
    private Set<String> categoriasCompletadas;

    public Ficha() {
        this.categoriasCompletadas = new HashSet<>();
    }

    public void completar(String categoria) {
        categoriasCompletadas.add(categoria.toLowerCase());
    }

    public boolean estaCompleta(String categoria) {
        return categoriasCompletadas.contains(categoria.toLowerCase());
    }

    public boolean todasCompletadas() {
        return categoriasCompletadas.size() == 6;
    }

    public Set<String> getCategoriasCompletadas() {
        return categoriasCompletadas;
    }
}

