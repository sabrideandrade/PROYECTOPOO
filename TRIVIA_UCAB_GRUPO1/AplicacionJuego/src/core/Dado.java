package core;

import java.util.Random;

public class Dado {
    private static final Random random = new Random();

    public static int lanzar() {
        return random.nextInt(6) + 1;
    }
}
