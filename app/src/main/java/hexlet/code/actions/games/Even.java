package hexlet.code.actions.games;

import hexlet.code.Engine;
import hexlet.code.actions.Actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Even implements Actions, Game {
    private final String name;
    private final Integer index;
    private static final String GAME_PREVIEW = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String GAME_NAME = "Even";
    private static final Integer GAME_INDEX = 2;

    private final Engine engine = new Engine();

    public Even() {
        this.name = GAME_NAME;
        this.index = GAME_INDEX;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getIndex() {
        return index;
    }

    @Override
    public void start() {
        engine.run(GAME_PREVIEW, prepareTrack());
    }

    private String getAnswer(Integer num) {
        return (num % 2) == 0 ? "yes" : "no";
    }

    @Override
    public Map<Integer, Map<String, String>> prepareTrack() {
        Map<Integer, Map<String, String>> track = new HashMap<>();
        var random = new Random();

        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var question = random.nextInt(1, 100);
            var answer = getAnswer(question);
            var exercise = engine.prepareExercise(Integer.toString(question), answer);
            track.put(i, exercise);
        }

        return track;
    }
}
