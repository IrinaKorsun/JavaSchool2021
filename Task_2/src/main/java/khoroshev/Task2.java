package khoroshev;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        double[] array = new double[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 1000;
        }
        System.out.printf("Максимальное значение в массиве %f\nМинимальное значение в массиве %f\nСреднее значение %f",
                Arrays.stream(array).max().getAsDouble(),
                Arrays.stream(array).min().getAsDouble(), Arrays.stream(array).average().getAsDouble());
    }
}