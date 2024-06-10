package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;

public class Calc {
    public static final String RULES = "What is the result of the expression?";

    private static final int UPPER_BOUND = 101;

    public static void runCalcGame() {
        var roundsQuantity = Engine.ROUNDS_QUANTITY;
        var gamesDataset = new String[roundsQuantity][];
        for (var round = 0; round < roundsQuantity; round++) {
            gamesDataset[round] = roundsDatasetGenerator();
        }

        Engine.run(gamesDataset, RULES);
    }

    private static String[] roundsDatasetGenerator() {
        var firstOperand = Utils.getRandomNumeric(UPPER_BOUND);
        var secondOperand = Utils.getRandomNumeric(UPPER_BOUND);
        var operator = getOperator();
        var expression = firstOperand + " " + operator + " " + secondOperand;
        var correctAnswer = calculateCorrectAnswer(firstOperand, secondOperand, operator);
        return new String[]{expression, String.valueOf(correctAnswer)};
    }

    private static char getOperator() {
        var operators = new char[]{'+', '-', '*'};
        return operators[new Random().nextInt(operators.length)];
    }

    private static int calculateCorrectAnswer(int firstOperand, int secondOperand, char operator) {
        return switch (operator) {
            case '+' -> firstOperand + secondOperand;
            case '-' -> firstOperand - secondOperand;
            case '*' -> firstOperand * secondOperand;
            default -> throw new RuntimeException("unknown operation");
        };
    }

}
