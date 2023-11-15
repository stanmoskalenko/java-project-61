package hexlet.code.actions.games;

import hexlet.code.Engine;
import hexlet.code.actions.Actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Prime implements Actions, Game {
    private final String name;
    private final Integer index;
    private static final String GAME_PREVIEW = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final String GAME_NAME = "Prime";
    private static final Integer GAME_INDEX = 6;
    private static final Integer PRIME_MIN = 1;
    private static final Integer PRIME_MAX = 1000;

    private final Engine engine = new Engine();

    public Prime() {
        this.name = GAME_NAME;
        this.index = GAME_INDEX;
    }

    @Override
    public void start() {
        engine.run(GAME_PREVIEW, prepareTrack());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getIndex() {
        return index;
    }

    private String getAnswer(Integer num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return "no";
            }
        }

        return "yes";
    }

    @Override
    public Map<Integer, Map<String, String>> prepareTrack() {
        Map<Integer, Map<String, String>> track = new HashMap<>();
        var random = new Random();

        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var question = random.nextInt(PRIME_MIN, PRIME_MAX);
            var answer = getAnswer(question);
            var exercise = engine.prepareExercise(Integer.toString(question), answer);
            track.put(i, exercise);
        }

        return track;
    }
}
