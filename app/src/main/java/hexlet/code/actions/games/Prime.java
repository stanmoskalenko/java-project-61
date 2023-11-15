package hexlet.code.actions.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Prime {
    private static final String GAME_PREVIEW = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final Integer PRIME_MIN = 1;
    private static final Integer PRIME_MAX = 1000;

    private static final Engine ENGINE = new Engine();

    private static String getAnswer(Integer num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return "no";
            }
        }

        return "yes";
    }

    public static void start() {
        ENGINE.run(GAME_PREVIEW, prepareTrack());
    }

    private static Map<Integer, Map<String, String>> prepareTrack() {
        Map<Integer, Map<String, String>> track = new HashMap<>();
        var random = new Random();

        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var question = random.nextInt(PRIME_MIN, PRIME_MAX);
            var answer = getAnswer(question);
            var exercise = ENGINE.prepareExercise(Integer.toString(question), answer);
            track.put(i, exercise);
        }

        return track;
    }
}
