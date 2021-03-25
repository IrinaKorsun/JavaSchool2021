package strashny;

public class Task2 {

    //  Метод возвращает максимальное значение из массива
    static private Double maxValue(Double[] array) {
        Double max = array[0];
        for (Double i : array) {
            if (max < i) max = i;
        }
        return max;
    }

    //    Метод возвращает минимальное значение из массива
    static private Double minValue(Double[] array) {
        Double min = array[0];
        for (Double i : array) {
            if (min > i) min = i;
        }
        return min;
    }

    //    Метод возвращает среднеарифметическое из массива
    static private Double middleValue(Double[] array) {
        Double middle = 0D;
        for (Double i : array) {
            middle = middle + i;
        }
        return middle / array.length;
    }

    public static void main(String[] args) {
//      Объявлем массив типа Double размером 10
        Double[] array = new Double[10];

//      Заполняем массив значением в диапазоне [0;1]
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }

//      Выводим на экран значение массива
        for (Double i : array) {
            System.out.println(i + " ");
        }

//      Выводим пустую строку
        System.out.println();
//      Выводим масимальное значение массива
        System.out.println("Максимальное значение = " + maxValue(array));
//      Выводим минимальное значение массива
        System.out.println("Минимальное значение = " + minValue(array));
//      Выводим среднеарифметическое массива
        System.out.println("Среднеарифметическое значение = " + middleValue(array));

    }

}
