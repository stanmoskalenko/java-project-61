package hexlet.code.actions;

import hexlet.code.Engine;

public class Greet implements Actions {
    private final String name;
    private final Integer index;
    private static String userName;

    private static final String HELLO_PREVIEW = "Welcome to the Brain Games!\nMay I have your name?";
    private static final String ACTIONS_NAME = "Greet";
    private static final Integer ACTIONS_INDEX = 1;
    private static Engine engine = new Engine();

    public static String getUserName() {
        if (userName == null) {
            engine.push(HELLO_PREVIEW);
            userName = engine.readString();
            engine.push("Hello, " + userName + "!");
        }

        return userName;
    }

    @Override
    public void start() {
        getUserName();
        engine.exit();
    }

    public Greet() {
        this.name = ACTIONS_NAME;
        this.index = ACTIONS_INDEX;
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
