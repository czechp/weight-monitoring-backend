package app.web.utilities.tools;

import java.util.Random;
import java.util.UUID;

public class RandomValueGenerator {
    private static final Random random = new Random();

    public static int randomInt() {
        return random.nextInt();
    }

    public static String randomString() {
        return UUID.randomUUID().toString();
    }

    public static float randomFloat() {
        return random.nextFloat();
    }

    public static boolean randomBoolean() {
        return random.nextBoolean();
    }

    public static long randomLong() {
        return random.nextLong();
    }

}
