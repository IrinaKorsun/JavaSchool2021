package komissarov;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector vectorA = new Vector(5, 1, 8);
        Vector vectorB = new Vector(8, 3, 4);

        System.out.println("Длина вектора: " + vectorA.vectorLength());
        System.out.println("Скалярное произведение векторов: " + vectorA.scalarProduct(vectorB));
        System.out.println("Векторное произведение векторов: " + vectorA.vectorСomposition(vectorB));
        System.out.println("Вычисление угла между векторами: " + vectorA.angleBetweenVectors(vectorB));
        System.out.println("Вычисление суммы векторов: " + vectorA.vectorSum(vectorB));
        System.out.println("Вычисление разности векторов: " + vectorA.vectorDiff(vectorB));
        System.out.println("Массив случайных векторов: " + Arrays.toString(Vector.arrayOfVectors(3)));
    }
}
