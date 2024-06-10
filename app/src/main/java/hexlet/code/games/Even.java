package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;

public class Even {
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final int UPPER_BOUND = 101;

    public static void runEvenGame() {
        var roundsQuantity = Engine.ROUNDS_QUANTITY;
        var gamesDataset = new String[roundsQuantity][];
        for (var round = 0; round < roundsQuantity; round++) {
            gamesDataset[round] = roundsDatasetGenerator();
        }

        Engine.run(gamesDataset, RULES);
    }

    private static String[] roundsDatasetGenerator() {
        var number = Utils.getRandomNumeric(UPPER_BOUND);
        var correctAnswer = isEven(number) ? "yes" : "no";
        return new String[]{String.valueOf(number), correctAnswer};
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
