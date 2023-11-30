package hexlet.code;

import java.util.Scanner;

public class Even {
    public static void isEven() {

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        int quantityRightAnswers = 3;

        while (counter < quantityRightAnswers) {

            int number = getQuestionNumber();
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String answer = scanner.next();
            String rightAnswer = ((number % 2) == 0) ? "yes" : "no";

            if ((number % 2) == 0 && answer.equals(rightAnswer)) {
                counter++;
                System.out.println("Correct!");
            } else if ((number % 2) != 0 && answer.equals(rightAnswer)) {
                counter++;
                System.out.println("Correct!");
            } else {
                System.out.println(answer + " is wrong answer ;(. Correct answer was " + rightAnswer);
                System.out.println("Let's try again, " + Cli.userName + "?");
                System.out.print("Answer 'yes' if you want to try again, otherwise answer 'no' ");
                String answerToTryAgain = scanner.next();

                if (answerToTryAgain.equals("yes")) {
                    isEven();
                } else {
                    System.out.println("Goodbye, " + Cli.userName + "!");
                }
                break;
            }

            if (counter == 3) {
                System.out.println("Congratulations, " + Cli.userName);
            }
        }
    }
    private static int getQuestionNumber() {
        int minNumber = 1;
        int maxNumber = 100;
        return (int) (Math.random() * maxNumber) + minNumber;
    }
}
