package hexlet.code.actions.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Calc {
    private static final String GAME_PREVIEW = "What is the result of the expression?";
    private static final Integer MIN_RANDOM_INT = 1;
    private static final Integer MAX_RANDOM_INT = 100;
    private static final Integer OPERATIONS_START_IDX = 0;
    private static final List<String> OPERATIONS = List.of("+", "-", "*");

    private static Engine engine = new Engine();

    public static void start() {
        engine.run(GAME_PREVIEW, prepareTrack());
    }

    private static String getAnswer(Integer firstOperand, Integer secondOperand, String operation) {
        return switch (operation) {
            case ("+") -> Integer.toString(firstOperand + secondOperand);
            case ("-") -> Integer.toString(firstOperand - secondOperand);
            case ("*") -> Integer.toString(firstOperand * secondOperand);
            default -> String.valueOf(firstOperand / secondOperand);
        };
    }

    private static Map<Integer, Map<String, String>> prepareTrack() {
        Map<Integer, Map<String, String>> track = new HashMap<>();
        var random = new Random();

        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var firstOperand = random.nextInt(MIN_RANDOM_INT, MAX_RANDOM_INT);
            var secondOperand = random.nextInt(MIN_RANDOM_INT, MAX_RANDOM_INT);
            var operation = OPERATIONS.get(random.nextInt(OPERATIONS_START_IDX, OPERATIONS.size()));
            var question = firstOperand + " " + operation + " " + secondOperand;
            var answer = getAnswer(firstOperand, secondOperand, operation);
            var exercise = engine.prepareExercise(question, answer);
            track.put(i, exercise);
        }

        return track;
    }


}
