package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        switch (choice) {
            case "0":
                scanner.close();
                System.out.println("Goodbye!");
                break;
            case "1":
                Cli.greeting();
                scanner.close();
                break;
            case "2":
                Cli.greeting();
                Even.isEven();
                scanner.close();
                break;
            default:
                scanner.close();
                System.out.println("You entered a non-existent selection value");
                break;
        }
    }
}
