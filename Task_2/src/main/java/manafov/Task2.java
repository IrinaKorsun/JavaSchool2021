package manafov;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int arrLength = scanner.nextInt();

        double[] array = new double[arrLength];
        System.out.println("Элементы массива:");
        for (int i = 0; i < arrLength; i++) {
            array[i] = Math.random();
            System.out.printf("%.3f\n", array[i]);
        }

        OptionalDouble max = Arrays.stream(array).max();
        OptionalDouble min = Arrays.stream(array).min();
        OptionalDouble avg = Arrays.stream(array).average();
        if (max.isPresent()) {
            System.out.printf("Максимум: %.3f\n", max.getAsDouble());
        }
        if (min.isPresent()) {
            System.out.printf("Минимум: %.3f\n", min.getAsDouble());
        }
        if (avg.isPresent()) {
            System.out.printf("Среднее: %.3f\n", avg.getAsDouble());
        }
    }
}
