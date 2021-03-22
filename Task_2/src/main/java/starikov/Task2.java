package starikov;

import java.util.Locale;

public class Task2 {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 7;
        final int RANGE_BOUND_UPPER = 10;

        int maxValue, minValue, sum;
        double averageValue;

        int[] numbers = new int[ARRAY_SIZE];

        System.out.print("Source array: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * RANGE_BOUND_UPPER + 1);
            System.out.print(numbers[i] + " ");
        }

        maxValue = minValue = sum = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (maxValue < numbers[i]) maxValue = numbers[i];
            if (minValue > numbers[i]) minValue = numbers[i];
            sum += numbers[i];
        }

        averageValue = (double) sum / numbers.length;

        System.out.print("\nMax: " + maxValue + "; Min: " + minValue + "; Average: ");
        System.out.printf(Locale.ENGLISH, "%.4f", averageValue);
    }
}
