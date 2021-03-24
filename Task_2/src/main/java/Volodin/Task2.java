package Volodin;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Task2 {
    public static void main(String[] args){

        // Объявление переменных
        double nums[], sum, mean;

        // Объявление переменных
        nums = new double[10];
        sum = 0;

        // Наполнение массива данными в интервале от [0, 1]
        for (int i = 0; i < nums.length; i++){
            nums[i] = Math.random();
            System.out.printf("%.3f %n",nums[i]);
        }

        // Суммирование данных массива и расчет среднего значения
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        mean = sum/nums.length;
        System.out.printf("Среднее значение массива: " + "%.3f %n", mean);

        // Нахождение максимального значения при помощи метода ".max"
        OptionalDouble max = Arrays.stream(nums).max();
        System.out.printf("Максимальное значение массива: " + "%.3f %n", max.getAsDouble());

        // Нахождение минимального значения при помощи метода ".min"
        OptionalDouble min = Arrays.stream(nums).min();
        System.out.printf("Минимальное значение массива: " + "%.3f %n", min.getAsDouble());
    }
}
