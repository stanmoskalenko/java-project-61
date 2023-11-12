package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {

    private static final String HELLO_PREVIEW = "Welcome to the Brain Games!"
           +  "\n May I have your name? ";
    private static final String GAME_PREVIEW = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final String CORRECT = "Correct!";
    private static final String INCORRECT = "'%s' is wrong answer ;(. Correct answer was '%s'.\n"
           +  "Let's try again, %s!!";

    private final Scanner sc = new Scanner(System.in);
    private final Random random = new Random();

    public static String checkAnswer(Integer num) {
        return (num % 2) == 0 ? YES : NO;
    }

    public void start() {
        System.out.println(HELLO_PREVIEW);
        var userName = sc.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(GAME_PREVIEW);

        for (var i = 0; i < 3; i++) {
            var randomInt = random.nextInt(1, 100);
            System.out.println("Question: " + randomInt);
            var userAnswer = sc.next().trim().toLowerCase();
            System.out.println("Your answer: " + userAnswer);

            if (checkAnswer(randomInt).equals(userAnswer)) {
                System.out.println(CORRECT);
            } else {
                var errorMsg = String.format(INCORRECT, userAnswer, checkAnswer(randomInt), userName);
                System.out.println(errorMsg);
                Runtime.getRuntime().exit(0);
            }
        }

        System.out.println("Congratulations, " + userName);
    }
}
