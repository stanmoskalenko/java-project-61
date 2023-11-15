package hexlet.code.actions;

import hexlet.code.Engine;

public class Greet {
    private static String userName;

    private static final String HELLO_PREVIEW = "Welcome to the Brain Games!\nMay I have your name?";
    private static final Engine ENGINE = new Engine();

    public static String getUserName() {
        if (userName == null) {
            ENGINE.push(HELLO_PREVIEW);
            userName = ENGINE.readString();
            ENGINE.push("Hello, " + userName + "!");
        }

        return userName;
    }

    public static void start() {
        getUserName();
        ENGINE.stop();
    }
}
