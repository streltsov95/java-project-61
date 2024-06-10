package hexlet.code;

import java.util.Random;

public class Utils {
    public static int getRandomNumeric(int leastValue, int upperBound) {
        return new Random().nextInt(leastValue, upperBound);
    }

    public static int getRandomNumeric(int upperBound) {
        return new Random().nextInt(upperBound);
    }
}
