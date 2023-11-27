package hexlet.code;


import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class App {
    private static final String EXIT = "0";
    private static final String GREET = "1";
    private static final String EVEN = "2";
    private static final String CALC = "3";
    private static final String GREATEST = "4";
    private static final String PROGRESSION = "5";
    private static final String PRIME = "6";

    public static void main(String[] args) {
        var menu = new StringBuilder()
                .append("Please enter the game number and press Enter.")
                .append("\n 0 – Exit")
                .append("\n 1 – Greet")
                .append("\n 2 – Even")
                .append("\n 3 – Calc")
                .append("\n 4 – GCD")
                .append("\n 5 – Progression")
                .append("\n 6 – Prime")
                .toString();

        System.out.println(menu);
        var userChoice = Engine.SC.next().trim();
        Engine.SC.close();

        switch (userChoice) {
            case EXIT -> System.out.println("👋 Bye bye");
            case GREET -> Cli.run();
            case EVEN -> Even.start();
            case CALC -> Calc.start();
            case GREATEST -> GCD.start();
            case PROGRESSION -> Progression.start();
            case PRIME -> Prime.start();
            default -> throw new IllegalArgumentException(
                    "Action with index "
                            + userChoice
                            + " not exist! Choice the correct game!");
        }
    }
}
