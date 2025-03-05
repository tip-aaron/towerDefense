package utils;

import java.util.Random;

public class NumberUtils {
    private static Random random = new Random();

    public static int randomInt(int max) {
        return NumberUtils.randomInt(0, max);
    }

    public static int randomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return random.nextInt(max - min + 1) + min;
    }
}
