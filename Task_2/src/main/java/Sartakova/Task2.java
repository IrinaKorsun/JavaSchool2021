package Sartakova;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        double[] myArray = new double[10];

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = Math.random();
        }

        double Max = Arrays.stream(myArray).max().getAsDouble();
        double Min = Arrays.stream(myArray).min().getAsDouble();
        double Average = Arrays.stream(myArray).average().getAsDouble();

        System.out.println("Максимальное значение = " + Max);
        System.out.println("Минимальное значение = " + Min);
        System.out.println("Среднее значение = " + Average);
    }
}

