package bogatov;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Task2 {
    public static void main(String[] args) {
        int[] array;
        int sizeArray;
        Scanner input = new Scanner(System.in);

        //Ввод данных и инициализация массива
        System.out.println("Введите размер массива:");
        sizeArray = input.nextInt();
        array = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            array[i] = (int) (Math.random() * sizeArray);
        }

        //Вывод данных
        System.out.println("Элементы массива размером " + sizeArray + ":");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Среднее значение массива: " + IntStream.of(array).average().getAsDouble());
        System.out.println("Максимальное значение массива: " + IntStream.of(array).max().getAsInt());
        System.out.println("Минимальное значение массива: " + IntStream.of(array).min().getAsInt());
    }
}