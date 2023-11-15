package hexlet.code.actions.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GCD {
    private static final String GAME_PREVIEW = "Find the greatest common divisor of given numbers.";
    private static final Integer MIN_RANDOM_INT = 1;
    private static final Integer MAX_RANDOM_INT = 100;

    private static final Engine ENGINE = new Engine();

    public static void start() {
        ENGINE.run(GAME_PREVIEW, prepareTrack());
    }

    private static String getAnswer(Integer firstOperand, Integer secondOperand) {
        while (secondOperand != 0) {
            int tmp = firstOperand % secondOperand;
            firstOperand = secondOperand;
            secondOperand = tmp;
        }

        return Integer.toString(firstOperand);
    }

    private static Map<Integer, Map<String, String>> prepareTrack() {
        Map<Integer, Map<String, String>> track = new HashMap<>();
        var random = new Random();

        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var firstOperand = random.nextInt(MIN_RANDOM_INT, MAX_RANDOM_INT);
            var secondOperand = random.nextInt(MIN_RANDOM_INT, MAX_RANDOM_INT);
            var question = firstOperand + " " + secondOperand;
            var answer = getAnswer(firstOperand, secondOperand);
            var exercise = ENGINE.prepareExercise(question, answer);
            track.put(i, exercise);
        }

        return track;
    }
}
