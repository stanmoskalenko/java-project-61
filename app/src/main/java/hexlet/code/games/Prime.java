package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Prime {
    private static final String GAME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final Integer PRIME_MIN = 1;
    private static final Integer PRIME_MAX = 1000;

    public static boolean isPrime(Integer num) {
        var answer = true;
        for (int idx = 2; idx < num; idx++) {
            if (num % idx == 0) {
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static void start() {
        List<Map<String, String>> track = new ArrayList<>();
        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var question = Utils.getRandomInt(PRIME_MIN, PRIME_MAX);
            var answer = isPrime(question) ? "yes" : "no";
            var exercise = Map.of(
                    "question", Integer.toString(question),
                    "answer", answer);
            track.add(exercise);
        }

        Engine.run(GAME_RULE, track);
    }
}
