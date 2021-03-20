package galuza;

public class Main {
    public static void main(String[] args) {

       double[] numbers = new double[5];
       StringBuilder sb = new StringBuilder();
       sb.append('[');
       double sum = 0;

       for (int i = 0; i < numbers.length; i++) {
           numbers[i] = Math.random();
           sum += numbers[i];
           sb.append(numbers[i]);
           sb.append(' ');
       }
       sb.deleteCharAt(sb.length() - 1);
       sb.append(']');

       double average = sum / numbers.length;

       double max = numbers[0];
       double min = numbers[0];
        for (double num : numbers) {
            if (num > max)
                max = num;
            if (num < min)
                min = num;
        }

        System.out.println("Для массива " + sb.toString());
        System.out.println("максимальное значение равно " + max + ", \nминимальное значение равно " + min + ",\nсреднее значение равно " + average);
    }
}
