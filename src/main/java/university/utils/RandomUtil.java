package university.utils;

import java.util.List;
import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();

    public static <T> T getRandomValueFromList(List<T> values) {
        return values.get(random.nextInt(values.size()));
    }

    public static int getRandomMark() {
        return random.nextInt(11);
    }
}
