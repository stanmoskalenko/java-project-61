package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Progression {
    private static final String GAME_RULE = "What number is missing in the progression?";
    private static final String HIDDEN_POSITION = ".. ";
    private static final Integer PROGRESSION_MIN_ITEMS = 5;
    private static final Integer PROGRESSION_MAX_ITEMS = 10;
    private static final Integer POSITION_START = 1;
    private static final Integer MAX_STEP = 10;
    private static final Integer MAX_RANDOM_INT = 10;

    private static List<Integer> prepareProgression(
            Integer startInt,
            Integer progressionLength,
            Integer progressionStep
    ) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(startInt);
        for (var idx = 0; idx < progressionLength; idx++) {
            var nextInt = numbers.get(idx) + progressionStep;
            numbers.add(nextInt);
        }

        return numbers;
    }

    public static void start() {
        List<Map<String, String>> questionAndAnswers = new ArrayList<>();
        int answer = 0;
        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var question = new StringBuilder();
            int startInt = Utils.getRandomInt(POSITION_START, MAX_RANDOM_INT);
            int progressionLength = Utils.getRandomInt(PROGRESSION_MIN_ITEMS, PROGRESSION_MAX_ITEMS);
            int progressionStep = Utils.getRandomInt(POSITION_START, MAX_STEP);
            int hiddenPosition = Utils.getRandomInt(POSITION_START, progressionLength);
            var progression = prepareProgression(startInt, progressionLength, progressionStep);

            for (var idx = 0; idx <= progressionLength; idx++) {
                var number = progression.get(idx);
                if (idx == hiddenPosition) {
                    answer = number;
                    question.append(HIDDEN_POSITION);
                } else {
                    question.append(number).append(" ");
                }
            }
            var exercise = Map.of(
                    "question", question.toString(),
                    "answer", Integer.toString(answer));
            questionAndAnswers.add(exercise);
        }
        Engine.run(GAME_RULE, questionAndAnswers);
    }
}
