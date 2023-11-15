package hexlet.code.actions;

import hexlet.code.Engine;

public class Exit implements Actions {
    private final String name;
    private final Integer index;

    private static final String ACTION_NAME = "Exit";
    private static final Integer ACTION_INDEX = 0;

    @Override
    public void start() {
        var engine = new Engine();
        engine.push("👋Bye bye");
        engine.stop();
    }

    public Exit() {
        this.name = ACTION_NAME;
        this.index = ACTION_INDEX;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getIndex() {
        return index;
    }
}
