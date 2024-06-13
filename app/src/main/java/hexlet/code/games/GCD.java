package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static final String RULES = "Find the greatest common divisor of given numbers.";

    private static final int LEAST_VALUE = 1;
    private static final int UPPER_BOUND = 101;

    public static void runGCDGame() {
        var roundsCount = Engine.ROUNDS_COUNT;
        var gamesDataset = new String[roundsCount][];
        for (var round = 0; round < roundsCount; round++) {
            gamesDataset[round] = roundsDatasetGenerator();
        }

        Engine.run(gamesDataset, RULES);
    }

    private static String[] roundsDatasetGenerator() {
        var number1 = Utils.getRandomNumeric(LEAST_VALUE, UPPER_BOUND);
        var number2 = Utils.getRandomNumeric(LEAST_VALUE, UPPER_BOUND);
        var question = number1 + " " + number2;
        var correctAnswer = calculateGcd(number1, number2);
        return new String[]{question, String.valueOf(correctAnswer)};
    }

    private static int calculateGcd(int number1, int number2) {
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
