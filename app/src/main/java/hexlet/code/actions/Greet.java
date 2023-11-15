package hexlet.code.actions;

import hexlet.code.Engine;

public class Greet {
    private static String userName;

    private static final String HELLO_PREVIEW = "Welcome to the Brain Games!\nMay I have your name?";
    private static Engine engine = new Engine();

    public static String getUserName() {
        if (userName == null) {
            engine.push(HELLO_PREVIEW);
            userName = engine.readString();
            engine.push("Hello, " + userName + "!");
        }

        return userName;
    }

    public static void start() {
        getUserName();
        engine.stop();
    }
}
