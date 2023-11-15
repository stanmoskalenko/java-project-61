package hexlet.code.actions.games;

import hexlet.code.Engine;
import hexlet.code.actions.Actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Calc implements Actions {
    private final String name;
    private final Integer index;

    private static final String GAME_NAME = "Calc";
    private static final Integer GAME_INDEX = 3;
    private static final String GAME_PREVIEW = "What is the result of the expression?";
    private static final List<String> OPERATIONS = List.of("+", "-", "*");

    private final Engine engine = new Engine();

    public Calc() {
        this.index = GAME_INDEX;
        this.name = GAME_NAME;
    }

    @Override
    public Integer getIndex() {
        return index;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void start() {
        engine.run(GAME_PREVIEW, prepareTrack());
    }

    private String getAnswer(Integer firstOperand, Integer secondOperand, String operation) {
        return switch (operation) {
            case ("+") -> Integer.toString(firstOperand + secondOperand);
            case ("-") -> Integer.toString(firstOperand - secondOperand);
            case ("*") -> Integer.toString(firstOperand * secondOperand);
            default -> String.valueOf(firstOperand / secondOperand);
        };
    }

    private Map<Integer, Map<String, String>> prepareTrack() {
        Map<Integer, Map<String, String>> track = new HashMap<>();
        var random = new Random();

        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var firstOperand = random.nextInt(1, 100);
            var secondOperand = random.nextInt(1, 100);
            var operation = OPERATIONS.get(random.nextInt(0, OPERATIONS.size()));
            var question = firstOperand + " " + operation + " " + secondOperand;
            var answer = getAnswer(firstOperand, secondOperand, operation);
            var exercise = engine.prepareExercise(question, answer);
            track.put(i, exercise);
        }

        return track;
    }


}
