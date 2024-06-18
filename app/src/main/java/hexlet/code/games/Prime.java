package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static final int LOWER_BOUND = 2;
    private static final int UPPER_BOUND = 101;

    public static void run() {
        var roundsCount = Engine.ROUNDS_COUNT;
        var gamesDataset = new String[roundsCount][];
        for (var round = 0; round < roundsCount; round++) {
            gamesDataset[round] = generateGamesData();
        }

        Engine.run(gamesDataset, RULES);
    }

    private static String[] generateGamesData() {
        int number = Utils.getRandomNumeric(LOWER_BOUND, UPPER_BOUND);
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
