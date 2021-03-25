package rozhkovnikita;

public class Task2 {
    public static void main(String[] args) {
        int n = 5;
        double[] array = new double[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }

        double max = array[0];
        double min = array[0];
        double avg = 0;

        for (double arr : array) {
            if (max < arr)
                max = arr;
            if (min > arr)
                min = arr;
            avg += arr / array.length;
        }

        System.out.println("Максимальное число: " + max);
        System.out.println("Минимальное число:  " + min);
        System.out.println("Среднее значение " + avg);
    }
}