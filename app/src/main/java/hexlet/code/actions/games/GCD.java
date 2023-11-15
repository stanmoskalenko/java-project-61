package hexlet.code.actions.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GCD {
    private static final String GAME_PREVIEW = "Find the greatest common divisor of given numbers.";

    private static Engine engine = new Engine();

    public static void start() {
        engine.run(GAME_PREVIEW, prepareTrack());
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
            var firstOperand = random.nextInt(1, 100);
            var secondOperand = random.nextInt(1, 100);
            var question = firstOperand + " " + secondOperand;
            var answer = getAnswer(firstOperand, secondOperand);
            var exercise = engine.prepareExercise(question, answer);
            track.put(i, exercise);
        }

        return track;
    }
}
