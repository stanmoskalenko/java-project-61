package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GCD {
    private static final String GAME_PREVIEW = "Find the greatest common divisor of given numbers.";
    private static final Integer MIN_RANDOM_INT = 1;
    private static final Integer MAX_RANDOM_INT = 100;

    public static void start() {
        Engine.run(GAME_PREVIEW, prepareTrack());
    }

    private static String getAnswer(Integer firstOperand, Integer secondOperand) {
        while (secondOperand != 0) {
            int tmp = firstOperand % secondOperand;
            firstOperand = secondOperand;
            secondOperand = tmp;
        }

        return Integer.toString(firstOperand);
    }

    private static List<Map<String, String>> prepareTrack() {
        List<Map<String, String>> track = new ArrayList<>();
        var random = new Random();

        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var firstOperand = random.nextInt(MIN_RANDOM_INT, MAX_RANDOM_INT);
            var secondOperand = random.nextInt(MIN_RANDOM_INT, MAX_RANDOM_INT);
            var question = firstOperand + " " + secondOperand;
            var answer = getAnswer(firstOperand, secondOperand);
            var exercise = Engine.prepareExercise(question, answer);
            track.add(exercise);
        }

        return track;
    }
}
