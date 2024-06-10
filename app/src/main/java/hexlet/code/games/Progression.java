package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;

public class Progression {
    public static final String RULES = "What number is missing in the progression?";

    public static void runProgressionGame() {
        var roundsQuantity = Engine.ROUNDS_QUANTITY;
        var gamesDataset = new String[roundsQuantity][];
        for (var round = 0; round < roundsQuantity; round++) {
            gamesDataset[round] = roundsDatasetGenerator();
        }

        Engine.run(gamesDataset, RULES);
    }

    private static String[] roundsDatasetGenerator() {
        int firstNumber = new Random().nextInt(1, 101);
        int progressionLength = new Random().nextInt(5, 11);
        int progressionStep = new Random().nextInt(2, 16);
        int hiddenNumber = new Random().nextInt(progressionLength);

        String[] progression = progressionGenerator(firstNumber, progressionLength, progressionStep);
        String[] modifiedProgression = hideNumber(progression, hiddenNumber);

        String question = String.join(" ", modifiedProgression);
        String correctAnswer = progression[hiddenNumber];

        return new String[]{question, correctAnswer};
    }

    private static String[] progressionGenerator(int firstNumber, int length, int step) {
        String[] progression = new String[length];
        int accumulator = firstNumber;
        for (var i = 0; i < length; i++) {
            progression[i] = String.valueOf(accumulator);
            accumulator += step;
        }

        return progression;
    }

    private static String[] hideNumber(String[] progression, int hiddenPosition) {
        String[] modifiedProgression = Arrays.copyOf(progression, progression.length);
        modifiedProgression[hiddenPosition] = "..";

        return modifiedProgression;
    }
}
