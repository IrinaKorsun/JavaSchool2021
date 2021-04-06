package shkabrov;

public class NumberOperations {
    public static int calculateRandomNumber(int minValue, int maxValue) {
        return minValue + (int)(Math.random() * maxValue); // правая граница не включена в диапазон
    }
}
