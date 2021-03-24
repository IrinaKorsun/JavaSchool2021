package mozzherin;

public class Task2 {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = 32;
        final int RANGE = 100;

        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        int sumVal = 0;
        int avgVal;

        int[] array = new int[ARRAY_LENGTH];

        for (int i = 0; i < ARRAY_LENGTH - 1; i++) {
            array[i] = (int) (Math.random() * RANGE);

            maxVal = Math.max(array[i], maxVal);
            minVal = Math.min(array[i], minVal);
            sumVal += array[i];
        }
        avgVal = sumVal / ARRAY_LENGTH;

        System.out.println("Максимальное значение = " + maxVal);
        System.out.println("Минимальное значение = " + minVal);
        System.out.println("Среднее значение = " + avgVal);
    }
}
