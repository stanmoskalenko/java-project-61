package hexlet.code;


import hexlet.code.actions.Exit;
import hexlet.code.actions.Greet;
import hexlet.code.actions.games.Calc;
import hexlet.code.actions.games.Even;
import hexlet.code.actions.games.GCD;
import hexlet.code.actions.games.Prime;
import hexlet.code.actions.games.Progression;

public class App {
    private static final String EXIT = "0";
    private static final String GREET = "1";
    private static final String EVEN = "2";
    private static final String CALC = "3";
    private static final String GREATEST = "4";
    private static final String PROGR = "5";
    private static final String PRIME = "6";

    public static void run() {
        var engine = new Engine();
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

        engine.push(menu);
        var userChoice = engine.readString();

        switch (userChoice) {
            case EXIT -> Exit.start();
            case GREET -> Greet.start();
            case EVEN -> Even.start();
            case CALC -> Calc.start();
            case GREATEST -> GCD.start();
            case PROGR -> Progression.start();
            case PRIME -> Prime.start();
            default -> engine.push("Action with index " + userChoice + " not exist! Choice the correct game!");
        }
    }

    public static void main(String[] args) {
        run();
    }
}
