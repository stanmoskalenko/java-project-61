package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public final class Engine {

    public static final int ROUND_COUNT = 3;
    private static final String HELLO_PREVIEW = "Welcome to the Brain Games!\nMay I have your name?";
    private static final String INCORRECT = "'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!!";
    private static final Scanner SC = new Scanner(System.in);

    public static String readString() {
        return SC.next().trim();
    }

    public static void push(String msg) {
        System.out.println(msg);
    }

    public static Map<String, String> prepareExercise(String question, String answer) {
        return Map.of(
                "question", question,
                "answer", answer);
    }

    public static String greet() {
        Engine.push(HELLO_PREVIEW);
        var userName = readString();
        Engine.push("Hello, " + userName + "!");

        return userName;
    }

    public static void run(String gameRule, List<Map<String, String>> track) {
        var userName = greet();
        push(gameRule);

        for (var i = 0; i < ROUND_COUNT; i++) {
            var exercise = track.get(i);
            var question = exercise.get("question");
            var answer = exercise.get("answer");

            push("Question: " + question);
            var userAnswer = readString();
            push("Your answer: " + userAnswer);

            if (userAnswer.toLowerCase().equals(answer)) {
                push("Correct!");
            } else {
                throw new IllegalArgumentException(String.format(INCORRECT, userAnswer, answer, userName));
            }
        }
        push("Congratulations, " + userName + "!");
    }
}
