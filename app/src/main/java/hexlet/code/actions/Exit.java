package hexlet.code.actions;

import hexlet.code.Engine;

public class Exit {
    public static void start() {
        var engine = new Engine();
        engine.push("👋 Bye bye");
        engine.stop();
    }
}
