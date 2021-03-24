package berezin;

import java.util.Arrays;

public class ArrayProcessor {

    public static void main(String[] args) {
        double[] array = new double[10];
        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
            System.out.println(array[i]);
        }
        Arrays.sort(array);
        for (double v : array) {
            sum += v;
        }

        System.out.println("Максимальное значение равно: " + array[array.length - 1]);
        System.out.println("Минимальное значение равно: " + array[0]);
        System.out.println("Среднее арифметическое равно: " + sum / array.length);

    }
}
