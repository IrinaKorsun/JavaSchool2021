package galuza;


import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        double[] numbers = new double[5];
        double sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Math.random();
            sum += numbers[i];
        }

        double average = sum / numbers.length;

        double max = numbers[0];
        double min = numbers[0];

        for (double elem : numbers) {
            if (max < elem)
                max = elem;
            if (min > elem)
                min = elem;
        }

        System.out.println("Для массива " + Arrays.toString(numbers) + "\nмаксимальное значение равно " + max +
                ", \nминимальное значение равно " + min + ", \nсреднее значение равно " + average);
    }
}
