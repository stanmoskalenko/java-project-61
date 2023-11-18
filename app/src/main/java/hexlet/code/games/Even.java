package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Even {
    private static final String GAME_PREVIEW = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final Integer MIN_RANDOM_INT = 1;
    private static final Integer MAX_RANDOM_INT = 100;

    public static void start() {
        Engine.run(GAME_PREVIEW, prepareTrack());
    }

    private static List<Map<String, String>> prepareTrack() {
        List<Map<String, String>> track = new ArrayList<>();
        var random = new Random();

        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            var question = random.nextInt(MIN_RANDOM_INT, MAX_RANDOM_INT);
            var answer = (question % 2) == 0 ? "yes" : "no";
            var exercise = Engine.prepareExercise(Integer.toString(question), answer);
            track.add(exercise);
        }

        return track;
    }
}