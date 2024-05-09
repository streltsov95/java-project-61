package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);

        String choice = scanner.next();
        switch (choice) {
            case "0":
                System.out.println("Goodbye!");
                scanner.close();
                break;
            case "1":
                Cli.greeting();
                scanner.close();
                break;
            case "2":
                Even.runEvenGame();
                scanner.close();
                break;
            case "3":
                Calc.runCalcGame();
                scanner.close();
                break;
            default:
                System.out.println("You entered a non-existent selection value");
                scanner.close();
                break;
        }
    }
}
