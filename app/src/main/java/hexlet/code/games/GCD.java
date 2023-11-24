package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GCD {
    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";
    private static final Integer MIN_RANDOM_INT = 1;
    private static final Integer MAX_RANDOM_INT = 100;

    private static String getGratestDevisor(Integer firstOperand, Integer secondOperand) {
        while (secondOperand != 0) {
            int tmp = firstOperand % secondOperand;
            firstOperand = secondOperand;
            secondOperand = tmp;
        }

        return Integer.toString(firstOperand);
    }

    public static void start() {
        List<Map<String, String>> track = new ArrayList<>();
        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var firstOperand = Utils.getRandomInt(MIN_RANDOM_INT, MAX_RANDOM_INT);
            var secondOperand = Utils.getRandomInt(MIN_RANDOM_INT, MAX_RANDOM_INT);
            var question = firstOperand + " " + secondOperand;
            var answer = getGratestDevisor(firstOperand, secondOperand);
            var exercise = Map.of(
                    "question", question,
                    "answer", answer);
            track.add(exercise);
        }

        Engine.run(GAME_RULE, track);
    }
}
