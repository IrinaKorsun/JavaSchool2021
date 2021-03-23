package shakina;


import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Task2 {
    public static void main(String[] args) {
        double[] array = new double[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 20;
        }

        System.out.println("Массив из случайных чисел: \n" + Arrays.toString(array));

        System.out.println("Максимум: " + DoubleStream.of(array).max().getAsDouble());
        System.out.println("Минимум: " + DoubleStream.of(array).min().getAsDouble());
        System.out.println("Среднее: " + DoubleStream.of(array).average().getAsDouble());

    }
}
