package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Prime {
    public static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void runPrimeGame() {
        var roundsQuantity = Engine.ROUNDS_QUANTITY;
        var gamesDataset = new String[roundsQuantity][];
        for (var round = 0; round < roundsQuantity; round++) {
            gamesDataset[round] = roundsDatasetGenerator();
        }

        Engine.run(gamesDataset, RULES);
    }

    private static String[] roundsDatasetGenerator() {
        int number = new Random().nextInt(2, 101);
        String correctAnswer = isPrime(number) ? "yes" : "no";
        String question = String.valueOf(number);
        return new String[]{question, correctAnswer};
    }

    private static boolean isPrime(int number) {
        for (var i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
