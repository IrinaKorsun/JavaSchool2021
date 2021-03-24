package komissarov;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        double[] arr = fillArray(10);
        double min = arr[0];
        double max = arr[0];
        double sum = arr[0];
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
            sum += arr[i];
        }
        System.out.println("Минимальное значение массива:" + min);
        System.out.println("Максимальное значение массива:" + max);
        System.out.println("Среднее значение массива:" + sum / arr.length);
    }

    public static double[] fillArray(int size) { //Метод заполнения массива
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Math.random();
        }
        return arr;
    }
}
