package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_COUNT = 3;

    public static void run(String[][] gamesDataset, String rules) {
        String username = Cli.greeting();
        System.out.println(rules);
        Scanner scanner = new Scanner(System.in);
        for (String[] gameData : gamesDataset) {
            String question = gameData[0];
            String correctAnswer = gameData[1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String answer = scanner.next();
            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("\'" + answer + "\'"
                        + " is wrong answer ;(. Correct answer was "
                        + "\'" + correctAnswer + "\'.");
                System.out.println("Let's try again, " + username + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + username + "!");
    }
}
