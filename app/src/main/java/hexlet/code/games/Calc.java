package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Calc {
    private static final String GAME_RULE = "What is the result of the expression?";
    private static final Integer MIN_RANDOM_INT = 1;
    private static final Integer MAX_RANDOM_INT = 100;
    private static final Integer OPERATIONS_START_IDX = 0;
    private static final List<String> OPERATIONS = List.of("+", "-", "*");

    private static String calculate(String operation, Integer firstOperand, Integer secondOperand) {
        return switch (operation) {
            case ("+") -> Integer.toString(firstOperand + secondOperand);
            case ("-") -> Integer.toString(firstOperand - secondOperand);
            case ("*") -> Integer.toString(firstOperand * secondOperand);
            default -> throw new IllegalArgumentException("Unexpected operation!");
        };
    }

    public static void start() {
        List<Map<String, String>> track = new ArrayList<>();
        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var firstOperand = Utils.getRandomInt(MIN_RANDOM_INT, MAX_RANDOM_INT);
            var secondOperand = Utils.getRandomInt(MIN_RANDOM_INT, MAX_RANDOM_INT);
            var operation = OPERATIONS.get(Utils.getRandomInt(OPERATIONS_START_IDX, OPERATIONS.size()));
            var question = firstOperand + " " + operation + " " + secondOperand;
            var answer = calculate(operation, firstOperand, secondOperand);
            var exercise = Map.of(
                    "question", question,
                    "answer", answer);
            track.add(exercise);
        }

        Engine.run(GAME_RULE, track);
    }


}
