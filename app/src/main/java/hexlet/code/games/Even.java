package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Even {
    private static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final Integer MIN_RANDOM_INT = 1;
    private static final Integer MAX_RANDOM_INT = 100;

    private static boolean isEven(Integer num) {
        return (num % 2) == 0;
    }

    public static void start() {
        List<Map<String, String>> track = new ArrayList<>();
        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var question = Utils.getRandomInt(MIN_RANDOM_INT, MAX_RANDOM_INT);
            var answer = isEven(question) ? "yes" : "no";
            var exercise = Map.of(
                    "question", Integer.toString(question),
                    "answer", answer);
            track.add(exercise);
        }

        Engine.run(GAME_RULE, track);
    }
}
