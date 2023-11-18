package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Prime {
    private static final String GAME_PREVIEW = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final Integer PRIME_MIN = 1;
    private static final Integer PRIME_MAX = 1000;

    private static String getAnswer(Integer num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return "no";
            }
        }

        return "yes";
    }

    public static void start() {
        Engine.run(GAME_PREVIEW, prepareTrack());
    }

    private static List<Map<String, String>> prepareTrack() {
        List<Map<String, String>> track = new ArrayList<>();
        var random = new Random();

        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var question = random.nextInt(PRIME_MIN, PRIME_MAX);
            var answer = getAnswer(question);
            var exercise = Engine.prepareExercise(Integer.toString(question), answer);
            track.add(exercise);
        }

        return track;
    }
}
