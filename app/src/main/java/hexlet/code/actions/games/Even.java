package hexlet.code.actions.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Even {
    private static final String GAME_PREVIEW = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final Integer MIN_RANDOM_INT = 1;
    private static final Integer MAX_RANDOM_INT = 100;

    private static final Engine ENGINE = new Engine();

    public static void start() {
        ENGINE.run(GAME_PREVIEW, prepareTrack());
    }

    private static Map<Integer, Map<String, String>> prepareTrack() {
        Map<Integer, Map<String, String>> track = new HashMap<>();
        var random = new Random();

        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var question = random.nextInt(MIN_RANDOM_INT, MAX_RANDOM_INT);
            var answer = (question % 2) == 0 ? "yes" : "no";
            var exercise = ENGINE.prepareExercise(Integer.toString(question), answer);
            track.put(i, exercise);
        }

        return track;
    }
}
