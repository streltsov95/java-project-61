package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GCD {
    public static final String RULES = "Find the greatest common divisor of given numbers.";

    public static void runGCDGame() {
        var roundsQuantity = Engine.ROUNDS_QUANTITY;
        var gamesDataset = new String[roundsQuantity][];
        for (var round = 0; round < roundsQuantity; round++) {
            gamesDataset[round] = roundsDatasetGenerator();
        }

        Engine.run(gamesDataset, RULES);
    }

    private static String[] roundsDatasetGenerator() {
        var number1 = new Random().nextInt(1, 101);
        var number2 = new Random().nextInt(1, 101);
        var question = number1 + " " + number2;
        var correctAnswer = gcd(number1, number2);
        return new String[]{question, String.valueOf(correctAnswer)};
    }

    private static int gcd(int number1, int number2) {
        while (number1 != 0 && number2 != 0) {
            if (number1 > number2) {
                number1 %= number2;
            } else {
                number2 %= number1;
            }
        }
        return number1 + number2;
    }
}
