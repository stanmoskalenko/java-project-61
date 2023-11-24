package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public final class Engine {
    public static final int ROUND_COUNT = 3;
    private static final String HELLO_PREVIEW = "Welcome to the Brain Games!\nMay I have your name?";
    private static final String INCORRECT = "'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!!";
    public static final Scanner SC = new Scanner(System.in);

    public static void run(String gameRule, List<Map<String, String>> questionAndAnswers) {
        System.out.println(HELLO_PREVIEW);
        var userName = SC.next().trim();
        System.out.println("Hello, " + userName + "!");

        if (questionAndAnswers != null) {
            System.out.println(gameRule);

            var success = true;

            for (var i = 0; i < ROUND_COUNT; i++) {
                var exercise = questionAndAnswers.get(i);
                var question = exercise.get("question");
                var answer = exercise.get("answer");

                System.out.println("Question: " + question);
                var userAnswer = SC.next().trim();
                System.out.println("Your answer: " + userAnswer);

                if (userAnswer.toLowerCase().equals(answer)) {
                    System.out.println("Correct!");
                } else {
                    System.out.printf(INCORRECT, userAnswer, answer, userName);
                    success = false;
                    break;
                }
            }
            if (success) {
                System.out.println("Congratulations, " + userName + "!");
            }
        }
    }
}
