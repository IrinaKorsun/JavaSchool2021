package krivko;

import java.util.stream.*;

/**
 * Задание Task_2
 * Заполните массив случайным числами и выведете максимальное, минимальное и среднее значение
 *  используя метод Math.random()
 * @author krivko
 * @version 1
 */
public class Task2 {
    public static void main(String... agr ) {
        // Нужно ли вводить размерность массива и максимальные числа? Вроде нас ещё пока этому не учили D)
        //      так что пусть будут 10 и 100
        final int SIZE_ARRAY = 10;
        final int MAX_NUMBER = 100;

        int[] array = new int[SIZE_ARRAY];
        for (int i = 0; i < SIZE_ARRAY; i++)
            array[i] = (int)(Math.random() * MAX_NUMBER);

        System.out.println("Массив случайных чисел \t = " + IntStream.of(array).boxed().collect(Collectors.toList()));
        System.out.println("Максимальное значение \t = " + IntStream.of(array).max().getAsInt());
        System.out.println("Минимальное значение \t = " + IntStream.of(array).min().getAsInt());
        System.out.println("Среднее значение \t\t = " + (int)IntStream.of(array).average().orElseThrow(IllegalStateException::new));
    }
}
