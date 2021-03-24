package zatsepin;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {

        double[] numbers = new double[10];
        double sum = 0.0;
        for (int i = 0; i < 10; i++) {
            numbers[i] = Math.random();
        }
        System.out.println("The array is filled with 10 pseudo-random numbers.");
        Arrays.sort(numbers);
        System.out.println("Minimum number in an array: " + String.format("%.2f", numbers[0]));
        System.out.println("Maximum number in an array: " + String.format("%.2f", numbers[9]));

        for (int i = 0; i < 10; i++) {
            sum += numbers[i];
        }
        System.out.println("Average value in an array : " + String.format("%.2f", sum / numbers.length));
        System.out.println("Something went wrong!");
        System.out.println("Something went wrong!");
    }
}
