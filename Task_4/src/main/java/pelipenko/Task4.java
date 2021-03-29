package pelipenko;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Vector firstVector = new Vector((int)(Math.random() * 10), (int)(Math.random() * 10), (int)(Math.random() * 10));
        Vector secondVector = new Vector((int)(Math.random() * 10), (int)(Math.random() * 10), (int)(Math.random() * 10));

        System.out.println("Первый вектор: " + firstVector.toString());
        System.out.println("Второй вектор: " + secondVector.toString());
        System.out.println("Длина первого вектора: " + firstVector.sqrt());
        System.out.println("Длина второго вектора: " + secondVector.sqrt());
        System.out.println("Скалярное произведение векторов: " + firstVector.scalarMultiply(secondVector));
        System.out.println("Векторное произведение: " + firstVector.vectorsMultiply(secondVector).toString());
        System.out.println("Угол между векторами: " + firstVector.angles(secondVector));
        System.out.println("Сумма векторов: " + firstVector.sumVectors(secondVector).toString());
        System.out.println("Разность векторов: " + firstVector.subVectors(secondVector).toString());
        System.out.println("Введите количество векторов: ");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Vector[] vectors = Vector.newVector(count);
        System.out.println("Сгенерированные вектора: ");
        for (Vector i : vectors) {
            System.out.println(i.toString());
        }
    }
}
