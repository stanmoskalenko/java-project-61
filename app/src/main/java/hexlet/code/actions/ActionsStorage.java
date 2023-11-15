package hexlet.code.actions;


import hexlet.code.actions.games.Calc;
import hexlet.code.actions.games.Even;

import java.util.Comparator;
import java.util.List;

public class ActionsStorage {
    private final List<Actions> actions;

    public ActionsStorage() {
        actions = List.of(new Even(), new Calc(), new Greet(), new Exit());
    }

    public List<Actions> getActions() {
        return actions.stream()
                .sorted(Comparator.comparingInt(Actions::getIndex))
                .toList();
    }
}
