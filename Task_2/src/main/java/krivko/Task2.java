package krivko;

import java.util.stream.*;

/**
 * Задание 2
 * Заполните массив случайным числами и выведете максимальное, минимальное и среднее значение
 *  используя метод Math.random()
 * @author krivko
 * @since 22.03.2021
 * @version 4
 */
public class Task2 {
    public static void main(String... agr ) {
        // Размерность массива и максимальных чисел, к примеру пусть будут 10 и 100
        int size = 10;
        int maxNumber = 100;

        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = (int)(Math.random() * maxNumber);

        System.out.println("Массив случайных чисел \t = " + IntStream.of(array).boxed().collect(Collectors.toList()));
        System.out.println("Максимальное значение \t = " + IntStream.of(array).max().getAsInt());
        System.out.println("Минимальное значение \t = " + IntStream.of(array).min().getAsInt());
        System.out.println("Среднее значение \t\t = " + (int)IntStream.of(array).average().orElse(Double.NaN));
    }
}
