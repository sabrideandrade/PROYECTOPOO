// tablero/Tablero.java
package tablero;

import java.util.*;

public class Tablero {
    private final List<Casilla> casillasPerimetro = new ArrayList<>();
    private final List<List<Casilla>> rayos = new ArrayList<>();
    private Casilla centro;
    private final String[] categorias = {"geo", "his", "dep", "cie", "art", "ent"};
    private final int TOTAL_CASILLAS_CATEGORIA = 10;
    private final int TOTAL_ESPECIALES = 12;
    private final int[][] coordenadasHexagonales = new int[73][2];
    private final int WIDTH = 60;
    private final int HEIGHT = 25;

    public Tablero() {
        generarCasillas();
        asignarCoordenadas();
    }

    private void generarCasillas() {
        List<String> todas = new ArrayList<>();
        for (String cat : categorias) {
            for (int i = 0; i < TOTAL_CASILLAS_CATEGORIA; i++) {
                todas.add(cat);
            }
        }
        Collections.shuffle(todas);

        Set<Integer> especialesIdx = new HashSet<>();
        Random rand = new Random();
        while (especialesIdx.size() < TOTAL_ESPECIALES) {
            int idx = rand.nextInt(42);
            especialesIdx.add(idx);
        }

        for (int i = 0; i < 42; i++) {
            boolean esEsp = especialesIdx.contains(i);
            String cat = esEsp ? "esp" : todas.remove(0);
            casillasPerimetro.add(new Casilla(cat, esEsp));
        }

        for (int i = 0; i < 6; i++) {
            List<Casilla> rayo = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                String cat = todas.remove(0);
                rayo.add(new Casilla(cat, false));
            }
            rayos.add(rayo);
        }

        centro = new Casilla("cent", false);
    }

    private void asignarCoordenadas() {
        int[][] hex = {
                {30, 0}, {34, 1}, {38, 2}, {42, 3}, {46, 4}, {50, 5}, {54, 6}, {58, 7},
                {58, 9}, {54,10}, {50,11}, {46,12}, {42,13}, {38,14}, {34,15}, {30,16},
                {26,15}, {22,14}, {18,13}, {14,12}, {10,11}, {6,10}, {6, 8}, {10, 7},
                {14, 6}, {18, 5}, {22, 4}, {26, 3}, {30, 2}, {34, 3}, {38, 4}, {42, 5},
                {46, 6}, {50, 7}, {50, 9}, {46,10}, {42,11}, {38,12}, {34,13}, {30,14},
                {26,13}, {22,12}
        };
        for (int i = 0; i < hex.length; i++) {
            coordenadasHexagonales[i] = hex[i];
        }

        int[][] rayos = {
                {30, 1}, {30, 2}, {30, 3}, {30, 4}, {30, 5},
                {56, 7}, {52, 7}, {48, 7}, {44, 7}, {40, 7},
                {56, 9}, {52, 9}, {48, 9}, {44, 9}, {40, 9},
                {30,15}, {30,14}, {30,13}, {30,12}, {30,11},
                {8, 9}, {12, 9}, {16, 9}, {20, 9}, {24, 9},
                {8, 7}, {12, 7}, {16, 7}, {20, 7}, {24, 7}
        };
        for (int i = 0; i < rayos.length; i++) {
            coordenadasHexagonales[42 + i] = rayos[i];
        }

        coordenadasHexagonales[72] = new int[]{30, 8};
    }

    public void colocarFichaEn(int id) {
        for (Casilla c : casillasPerimetro) c.quitarFicha();
        for (List<Casilla> rayo : rayos) for (Casilla c : rayo) c.quitarFicha();
        centro.quitarFicha();

        if (id >= 0 && id < 42) casillasPerimetro.get(id).colocarFicha();
        else if (id >= 42 && id < 72) {
            int rayo = (id - 42) / 5;
            int pos = (id - 42) % 5;
            rayos.get(rayo).get(pos).colocarFicha();
        } else if (id == 72) centro.colocarFicha();
    }

    public void dibujarTablero() {
        String[][] canvas = new String[HEIGHT][WIDTH];
        for (String[] fila : canvas) Arrays.fill(fila, "     ");

        for (int i = 0; i < 42; i++) {
            int[] pos = coordenadasHexagonales[i];
            canvas[pos[1]][pos[0]] = casillasPerimetro.get(i).toString();
        }
        for (int i = 0; i < 30; i++) {
            int[] pos = coordenadasHexagonales[42 + i];
            int r = i / 5;
            int d = i % 5;
            canvas[pos[1]][pos[0]] = rayos.get(r).get(d).toString();
        }
        int[] cent = coordenadasHexagonales[72];
        canvas[cent[1]][cent[0]] = centro.toString();

        for (String[] fila : canvas) {
            for (String c : fila) System.out.print(c);
            System.out.println();
        }
    }
}
