package krivko;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Задание 4
 * Реализовать класс, описывайющий 3d вектор
 *  если что онлайн калькулятор векторов, для проверки
 *  https://ru.onlinemschool.com/math/assistance/vector/calc/
 * @author krivko
 * @since 27.03.2021
 * @version 2
 */
public class Task4 {
    public static void main(String... agr ) {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 7, 9);

        DecimalFormat f = new DecimalFormat("##.00");

        System.out.println("Вектор v1 = " + v1);
        System.out.println("Вектор v2 = " + v2);
        System.out.println("Длинна v1 = " + f.format(v1.length()));
        System.out.println("Длинна v2 = " + f.format(v2.length()));
        System.out.println("Скалярное произведение v1 * v2 = " + v1.scalar(v2));
        System.out.println("Векторное произведение v1 * v2 = " + v1.multiply(v2));
        System.out.println("Угол между v1 и v2 = " + v1.angle(v2));
        System.out.println("Сумма v1 + v2 = " + v1.add(v2));
        System.out.println("Разность v1 - v2 = " + v1.diff(v2));

        Vector[] array = Vector.arrayRandomVectors(5);
        System.out.println("Массив 5 случайных векторов: " + Arrays.toString(array));
    }
}
