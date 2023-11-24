package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Progression {
    private static final String GAME_RULE = "What number is missing in the progression?";
    private static final Integer PROGRESSION_MIN_ITEMS = 5;
    private static final Integer PROGRESSION_MAX_ITEMS = 10;
    private static final Integer POSITION_START = 1;
    private static final Integer MAX_STEP = 100;
    private static final Integer MAX_RANDOM_INT = 100;

    private static Map<String, String> prepareExercise(
            Integer startInt,
            List<Integer> numbers,
            Integer progressionLength,
            Integer progressionStep,
            Integer hiddenPosition
    ) {
        int answer = 0;
        var question = new StringBuilder();
        question.append(startInt);
        numbers.add(startInt);
        for (var idx = 0; idx < progressionLength; idx++) {
            var nextInt = numbers.get(idx) + progressionStep;
            numbers.add(nextInt);
            if (idx == hiddenPosition) {
                answer = nextInt;
                question.append(" ..");
            } else {
                question.append(" ").append(nextInt);
            }
        }
        return Map.of(
                "question", question.toString(),
                "answer", Integer.toString(answer));
    }

    public static void start() {
        List<Map<String, String>> track = new ArrayList<>();
        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            List<Integer> numbers = new ArrayList<>();
            var startInt = Utils.getRandomInt(POSITION_START, MAX_RANDOM_INT);
            var progressionLength = Utils.getRandomInt(PROGRESSION_MIN_ITEMS, PROGRESSION_MAX_ITEMS);
            var progressionStep = Utils.getRandomInt(POSITION_START, MAX_STEP);
            var hiddenPosition = Utils.getRandomInt(POSITION_START, progressionLength);
            var exercise = prepareExercise(startInt, numbers, progressionLength, progressionStep, hiddenPosition);

            track.add(exercise);
        }
        Engine.run(GAME_RULE, track);
    }
}
