package emelyanov;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(4, 6, 3);
        Vector vector2 = new Vector(7, 2, 9);

        System.out.println("Длина вектора: " + vector1.getLength());
        System.out.println("Скалярное произведение: " + vector1.getScalar(vector2));
        System.out.println("Векторное произведение с другим вектором: " + vector1.getVectorProduct(vector2));
        System.out.println("Вычисление угла между векторами или косинус угла: " + vector1.getAngle(vector2));
        System.out.println("Вычисление суммы: " + vector1.getSum(vector2));
        System.out.println("Вычисление разности: " + vector1.getDifference(vector2));
        System.out.println("Массив случайных векторов: " + Arrays.toString(Vector.getArrayRandomVectors(2)));
    }
}
