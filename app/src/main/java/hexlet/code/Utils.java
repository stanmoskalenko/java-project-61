package hexlet.code;

import java.util.Random;

public class Utils {
    public static Integer getRandomInt(Integer origin, Integer bound) {
        var random = new Random();

        return random.nextInt(origin, bound);
    }
}
