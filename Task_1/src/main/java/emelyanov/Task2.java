package emelyanov;

public class Task2 {
    public static void main(String[] args) {
        double array[] = new double[10];
        double min = 50, max = 0, average = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
            if (array[i] >= max) {
                max = array[i];
            }
            if (array[i] <= min) {
                min = array[i];
            }
            average += array[i];
        }

        System.out.println("Максимальное значение " + max);
        System.out.println("Минимальное значение " + min);
        System.out.println("Среднее значение " + average / array.length);
    }
}
