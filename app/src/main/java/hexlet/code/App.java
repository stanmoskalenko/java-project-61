package hexlet.code;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        var gameChoicePrev = new StringBuilder()
                .append("Please enter the game number and press Enter.")
                .append("\n 1 - Greet")
                .append("\n 2 – Even")
                .append("\n 0 - Exit")
                .toString();
        var sc = new Scanner(System.in);
        System.out.println(gameChoicePrev);
        var gameChoice = sc.nextInt();
        System.out.println("Your choice: " + gameChoice);

        switch (gameChoice) {
            case (1):
                var greetGame = new GreetGame();
                greetGame.start();
                break;
            case (2):
                var evenGame = new EvenGame();
                evenGame.start();
                break;
            case (0):
                Runtime.getRuntime().exit(0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + gameChoice);
        }
    }
}
