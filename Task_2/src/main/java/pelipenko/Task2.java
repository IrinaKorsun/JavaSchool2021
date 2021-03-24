package pelipenko;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;

        System.out.println("Введите размер массива");
        size = scanner.nextInt();
        double[] arr = new double[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random();
        }

        System.out.println("Минимальное значение массива: " + getMin(arr));
        System.out.println("Максимальное значение массива: " + getMax(arr));
        System.out.println("Среднее знчение массива: " + getAverage(arr));

    }

    private static double getMin(double[] arr) {
        double min = arr[0];

        for (double v : arr) {
            if (min > v) {
                min = v;
            }
        }
        return min;
    }

    private static double getMax(double[] arr) {
        double max = arr[arr.length - 1];

        for (double v : arr) {
            if (max < v) {
                max = v;
            }
        }
        return max;
    }

    private static double getAverage(double[] arr) {
        double average = 0.0;

        for (double v : arr) {
            average += v;
        }
        average /= arr.length;
        return average;

    }
}
