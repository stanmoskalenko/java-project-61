package hexlet.code;


import hexlet.code.actions.Actions;
import hexlet.code.actions.ActionsStorage;

public class App {

    public static void run() {
        var engine = new Engine();
        var actionsStorage = new ActionsStorage();
        StringBuilder games = new StringBuilder()
                .append("Please enter the game number and press Enter.");

        for (var game : actionsStorage.getActions()) {
            games.append("\n ")
                    .append(game.getIndex())
                    .append(" – ")
                    .append(game.getName());
        }
        var gameChoicePrev = games.toString();
        engine.push(gameChoicePrev);
        var userChoice = engine.readString();
        engine.push("Your choice: " + userChoice);

        actionsStorage.getActions().stream()
                .filter(action -> action.getIndex().toString().equals(userChoice))
                .forEach(Actions::start);
    }

    public static void main(String[] args) {
        run();
    }
}
