package hexlet.code.actions.games;

import hexlet.code.Engine;
import hexlet.code.actions.Actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GCD implements Actions, Game {
    private final String name;
    private final Integer index;

    private static final String GAME_PREVIEW = "Find the greatest common divisor of given numbers.";
    private static final String GAME_NAME = "GCD";
    private static final Integer GAME_INDEX = 4;

    private final Engine engine = new Engine();

    public GCD() {
        this.name = GAME_NAME;
        this.index = GAME_INDEX;
    }

    @Override
    public void start() {
        engine.run(GAME_PREVIEW, prepareTrack());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getIndex() {
        return index;
    }

    public String getAnswer(Integer firstOperand, Integer secondOperand) {
        while (secondOperand != 0) {
            int tmp = firstOperand % secondOperand;
            firstOperand = secondOperand;
            secondOperand = tmp;
        }

        return Integer.toString(firstOperand);
    }

    @Override
    public Map<Integer, Map<String, String>> prepareTrack() {
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
