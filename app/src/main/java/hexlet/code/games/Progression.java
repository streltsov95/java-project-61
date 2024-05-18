package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.StringJoiner;

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
        var progressionString = progressionGenerator();
        var progressionArray = progressionString.split(" ");
        var hiddenNumber = new Random().nextInt(progressionArray.length);
        var question = hideNumber(progressionString, hiddenNumber);
        var correctAnswer = progressionArray[hiddenNumber];
        return new String[]{question, correctAnswer};
    }

    private static String progressionGenerator() {
        int progressionLength = new Random().nextInt(5, 11);
        int progressionStep = new Random().nextInt(2, 16);
        int firstNumber = new Random().nextInt(1, 101);
        int nextNumber = firstNumber + progressionStep;
        StringBuilder progression = new StringBuilder(String.valueOf(firstNumber));
        for (var i = 1; i < progressionLength; i++) {
            progression.append(" ").append(nextNumber);
            nextNumber += progressionStep;
        }
        return progression.toString();
    }

    private static String hideNumber(String progression, int position) {
        var numbers = progression.split(" ");
        numbers[position] = "..";
        StringJoiner modifiedProgression = new StringJoiner(" ");
        for (var number : numbers) {
            modifiedProgression.add(number);
        }
        return modifiedProgression.toString();
    }
}
