package pelipenko;

import java.math.BigDecimal;
import java.util.Random;

public class RandomHelper {
    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static BigDecimal getRandomNumberUsingNextDouble(double min, double max) {
        Random r = new Random();
        double randomValue = min + (max - min) * r.nextDouble();
        return BigDecimal.valueOf(randomValue);
    }
}
