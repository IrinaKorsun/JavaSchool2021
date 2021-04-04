package podolyak;

import java.util.Arrays;

public class Task2 {
    private static final int LENGTH = 10;
    int[] randomNumbersArray = new int[LENGTH];
    int summ;

    /**
     * Метод добавляет в массив случайные числа от 0 до 100
     */
    public int[] fillArray() {
        for (int i = 0; i < LENGTH; i++) {
            int number = (int) (Math.random() * 100 + 1);
            randomNumbersArray[i] = number;
            summ += number;
        }
        System.out.println("Получен массив чисел: " + Arrays.toString(randomNumbersArray));
        return  randomNumbersArray;
    }

    public int[] getRandomNumbersArray() {
        return randomNumbersArray;
    }

    public int getSumm() {
        return summ;
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        Arrays.sort(task2.fillArray());
        System.out.println("Максимальное число в массиве: " + task2.getRandomNumbersArray()[task2.LENGTH - 1] + "\n" +
                "Минимальное число в массиве: " + task2.getRandomNumbersArray()[0] + "\n" +
                "Среднее число в массиве: " + task2.getSumm() / task2.LENGTH);
    }
}
