package hexlet.code;

import hexlet.code.actions.Greet;

import java.util.Map;
import java.util.Scanner;

public class Engine {
    public static final int ROUND_COUNT = 3;
    private static final String INCORRECT = "'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!!";

    public String readString() {
        var inputScanner = new Scanner(System.in);
        return inputScanner.next().trim();
    }

    public Map<String, String> prepareExercise(String question, String answer) {
        return Map.of(
                "question", question,
                "answer", answer);
    }

    public void push(String msg) {
        System.out.println(msg);
    }

    public void exit() {
        App.run();
    }

    public void stop() {
        Runtime.getRuntime().exit(0);
    }

    private static boolean checkAnswer(String userAnswer, String answer) {
        return userAnswer.equals(answer);
    }

    public void run(String gameRule, Map<Integer, Map<String, String>> track) {
        var userName = Greet.getUserName();
        push(gameRule);

        for (var i = 0; i < ROUND_COUNT; i++) {
            var exercise = track.get(i);
            var question = exercise.get("question");
            var answer = exercise.get("answer");

            push("Question: " + question);
            var userAnswer = readString();
            var normalizeUserAnswer = userAnswer.toLowerCase();
            push("Your answer: " + userAnswer);

            if (checkAnswer(normalizeUserAnswer, answer)) {
                push("Correct!");
            } else {
                var msg = String.format(INCORRECT, userAnswer, answer, userName);
                push(msg);
                exit();
            }
        }
        push("Congratulations, " + userName + "!");
        exit();
    }
}
