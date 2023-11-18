package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Progression {
    private static final String GAME_PREVIEW = "What number is missing in the progression?";
    private static final Integer PROGRESSION_MIN_ITEMS = 5;
    private static final Integer PROGRESSION_MAX_ITEMS = 10;
    private static final Integer POSITION_START = 1;
    private static final Integer MAX_STEP = 100;
    private static final Integer MAX_RANDOM_INT = 100;

    public static void start() {
        Engine.run(GAME_PREVIEW, prepareTrack());
    }

    private static List<Map<String, String>> prepareTrack() {
        List<Map<String, String>> track = new ArrayList<>();
        var random = new Random();

        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            List<Integer> numbers = new ArrayList<>();
            var startInt = random.nextInt(POSITION_START, MAX_RANDOM_INT);
            var progressionLength = random.nextInt(PROGRESSION_MIN_ITEMS, PROGRESSION_MAX_ITEMS);
            var progressionStep = random.nextInt(POSITION_START, MAX_STEP);
            var hiddenPosition = random.nextInt(POSITION_START, progressionLength);
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
            var exercise = Engine.prepareExercise(question.toString(), Integer.toString(answer));
            track.add(exercise);
        }

        return track;
    }
}
