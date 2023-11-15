package hexlet.code.actions;


import hexlet.code.actions.games.Calc;
import hexlet.code.actions.games.Even;
import hexlet.code.actions.games.GCD;
import hexlet.code.actions.games.Progression;

import java.util.Comparator;
import java.util.List;

public class ActionsStorage {
    private final List<Actions> actions;

    public ActionsStorage() {
        actions = List.of(
                new Even(),
                new Calc(),
                new Greet(),
                new Exit(),
                new GCD(),
                new Progression());
    }

    public List<Actions> getActions() {
        return actions.stream()
                .sorted(Comparator.comparingInt(Actions::getIndex))
                .toList();
    }
}
