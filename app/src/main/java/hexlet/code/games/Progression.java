package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;

public class Progression {
    public static final String RULES = "What number is missing in the progression?";

    private static final int NUMBER_LOWER_BOUND = 1;
    private static final int NUMBER_UPPER_BOUND = 101;

    private static final int PROGRESSION_LENGTH_LOWER_BOUND = 5;
    private static final int PROGRESSION_LENGTH_UPPER_BOUND = 11;

    private static final int PROGRESSION_STEP_LOWER_BOUND = 2;
    private static final int PROGRESSION_STEP_UPPER_BOUND = 16;


    public static void run() {
        var roundsCount = Engine.ROUNDS_COUNT;
        var gamesDataset = new String[roundsCount][];
        for (var round = 0; round < roundsCount; round++) {
            gamesDataset[round] = generateGamesData();
        }

        Engine.run(gamesDataset, RULES);
    }

    private static String[] generateGamesData() {
        int firstNumber = Utils.getRandomNumeric(NUMBER_LOWER_BOUND, NUMBER_UPPER_BOUND);
        int progressionLength = Utils.getRandomNumeric(PROGRESSION_LENGTH_LOWER_BOUND, PROGRESSION_LENGTH_UPPER_BOUND);
        int progressionStep = Utils.getRandomNumeric(PROGRESSION_STEP_LOWER_BOUND, PROGRESSION_STEP_UPPER_BOUND);
        int hiddenNumber = new Random().nextInt(progressionLength);

        String[] progression = generateProgression(firstNumber, progressionLength, progressionStep);
        String correctAnswer = progression[hiddenNumber];
        progression[hiddenNumber] = "..";
        String question = String.join(" ", progression);

        return new String[]{question, correctAnswer};
    }

    private static String[] generateProgression(int firstNumber, int length, int step) {
        String[] progression = new String[length];
        int accumulator = firstNumber;
        for (var i = 0; i < length; i++) {
            progression[i] = String.valueOf(accumulator);
            accumulator += step;
        }

        return progression;
    }
}
