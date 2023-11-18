package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GCD {
    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";
    private static final Integer MIN_RANDOM_INT = 1;
    private static final Integer MAX_RANDOM_INT = 100;

    public static void start() {
        List<Map<String, String>> track = new ArrayList<>();
        var random = new Random();

        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var firstOperand = random.nextInt(MIN_RANDOM_INT, MAX_RANDOM_INT);
            var secondOperand = random.nextInt(MIN_RANDOM_INT, MAX_RANDOM_INT);
            var question = firstOperand + " " + secondOperand;

            while (secondOperand != 0) {
                int tmp = firstOperand % secondOperand;
                firstOperand = secondOperand;
                secondOperand = tmp;
            }

            var answer = Integer.toString(firstOperand);
            var exercise = Map.of(
                    "question", question,
                    "answer", answer);
            track.add(exercise);
        }

        Engine.run(GAME_RULE, track);
    }
}
