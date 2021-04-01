package Sartakova;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        double[] myArray = new double[10];

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = Math.random();
        }

        double max = Arrays.stream(myArray).max().getAsDouble();
        double min = Arrays.stream(myArray).min().getAsDouble();
        double average = Arrays.stream(myArray).average().getAsDouble();

        System.out.println("Максимальное значение = " + max);
        System.out.println("Минимальное значение = " + min);
        System.out.println("Среднее значение = " + average);
    }
}

