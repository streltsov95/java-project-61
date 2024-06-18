package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;

public class Calc {
    public static final String RULES = "What is the result of the expression?";

    private static final int UPPER_BOUND = 101;

    private static final char[] OPERATORS = {'+', '-', '*'};

    public static void run() {
        var roundsCount = Engine.ROUNDS_COUNT;
        var gamesDataset = new String[roundsCount][];
        for (var round = 0; round < roundsCount; round++) {
            gamesDataset[round] = generateGamesData();
        }

        Engine.run(gamesDataset, RULES);
    }

    private static String[] generateGamesData() {
        var firstOperand = Utils.getRandomNumeric(UPPER_BOUND);
        var secondOperand = Utils.getRandomNumeric(UPPER_BOUND);
        var operator = getOperator();
        var expression = firstOperand + " " + operator + " " + secondOperand;
        var correctAnswer = calculateCorrectAnswer(firstOperand, secondOperand, operator);
        return new String[]{expression, String.valueOf(correctAnswer)};
    }

    private static char getOperator() {
        return OPERATORS[new Random().nextInt(OPERATORS.length)];
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
