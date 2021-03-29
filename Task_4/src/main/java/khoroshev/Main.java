package khoroshev;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double x1, x2, y1, y2, z1, z2;
        Vector[] vectors;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Координата х первого вектора:");
            x1 = scanner.nextDouble();
            System.out.println("Координата у первого вектора:");
            y1 = scanner.nextDouble();
            System.out.println("Координата z первого вектора:");
            z1 = scanner.nextDouble();
            System.out.println("Координата х второго вектора:");
            x2 = scanner.nextDouble();
            System.out.println("Координата у второго вектора:");
            y2 = scanner.nextDouble();
            System.out.println("Координата z второго вектора:");
            z2 = scanner.nextDouble();
            Vector vector1 = new Vector(x1, y1, z1);
            Vector vector2 = new Vector(x2, y2, z2);
            System.out.println("Длинна первого вектора: " + vector1.length());
            System.out.println("Длинна второго вектора: " + vector2.length());
            System.out.println("Скалярное произведение векторов: " + vector1.scalarMultiplication(vector2));
            System.out.println("Векторное произведение векторов: " + vector1.vectorMultiplication(vector2));
            System.out.println("Косинус между двумя углами: " + vector1.cosine(vector2));
            System.out.println("Вектор суммы векторов: " + vector1.sum(vector2));
            System.out.println("Вектор разности векторов: " + vector1.diff(vector2));
            System.out.println("Введите колличество веторов для создания из них массива: ");
            vectors = Vector.getArrayOfRandomVectors(scanner.nextInt());
            System.out.println("Векторы в массиве:");
            for (Vector vector : vectors) {
                System.out.println(vector);
            }
        } catch (InputMismatchException e) {
            System.out.println("Неправильный формат введенных данных, попробуйте ещё раз.");
        }
    }
}
