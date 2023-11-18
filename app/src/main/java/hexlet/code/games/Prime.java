package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Prime {
    private static final String GAME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final Integer PRIME_MIN = 1;
    private static final Integer PRIME_MAX = 1000;

    public static void start() {
        List<Map<String, String>> track = new ArrayList<>();
        var random = new Random();

        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var answer = "yes";
            var question = random.nextInt(PRIME_MIN, PRIME_MAX);

            for (int idx = 2; idx < question; idx++) {
                if (question % idx == 0) {
                    answer = "no";
                    break;
                }
            }
            var exercise = Map.of(
                    "question", Integer.toString(question),
                    "answer", answer);
            track.add(exercise);
        }

        Engine.run(GAME_RULE, track);
    }
}
