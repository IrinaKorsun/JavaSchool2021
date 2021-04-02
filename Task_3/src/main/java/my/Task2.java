package my;

import java.util.Arrays;

public class Task2 {
    final int LENGTH = 10;
    int[] randomNumbersArray = new int[LENGTH];


    /**
     * Метод добавляет в массив случайные числа от 0 до 100
     * затем сортирует его
     */
    public void addedNumbersInArray() {
        for (int i = 0; i < LENGTH; i++) {
            int number = (int) (Math.random() * 100 + 1);
            randomNumbersArray[i] = number;
        }
        Arrays.sort(randomNumbersArray);
        System.out.println("Получен массив чисел: " + Arrays.toString(randomNumbersArray));
    }

    public int[] getRandomNumbersArray() {
        return randomNumbersArray;
    }

    public static void main(String[] args) {

        Task2 task2 = new Task2();
        task2.addedNumbersInArray();
        System.out.println("Наибольшее число в массиве: " + task2.getRandomNumbersArray()[task2.LENGTH - 1] + "\n" +
                "Наименьшее число в массиве: " + task2.getRandomNumbersArray()[0] + "\n" +
                "Среднее число в массиве: " + task2.getRandomNumbersArray()[task2.LENGTH / 2]);


    }
}
