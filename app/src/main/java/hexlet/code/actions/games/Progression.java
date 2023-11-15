package hexlet.code.actions.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Progression {
    private static final String GAME_PREVIEW = "What number is missing in the progression?";
    private static final Integer PROGRESSION_MIN_ITEMS = 5;
    private static final Integer PROGRESSION_MAX_ITEMS = 10;

    private static Engine engine = new Engine();

    public static void start() {
        engine.run(GAME_PREVIEW, prepareTrack());
    }

    private static Map<Integer, Map<String, String>> prepareTrack() {
        Map<Integer, Map<String, String>> track = new HashMap<>();
        var random = new Random();

        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            List<Integer> numbers = new ArrayList<>();
            var startInt = random.nextInt(1, 99);
            var progressionLength = random.nextInt(PROGRESSION_MIN_ITEMS, PROGRESSION_MAX_ITEMS);
            var progressionStep = random.nextInt(1, 10);
            var hiddenPosition = random.nextInt(1, progressionLength);
            int answer = 0;
            var question = new StringBuilder();
            question.append(" ").append(startInt);

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
            var exercise = engine.prepareExercise(question.toString(), Integer.toString(answer));
            track.put(i, exercise);
        }

        return track;
    }
}
