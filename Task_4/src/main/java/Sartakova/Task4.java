package Sartakova;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Vector Vec1 = new Vector((Math.random() *10), (Math.random() *10), (Math.random() *10));
        Vector Vec2 = new Vector((Math.random() *10), (Math.random() *10), (Math.random() *10));

        System.out.println("1 вектор: " + Vec1.toString());
        System.out.println("2 вектор: " + Vec2.toString());
        System.out.println("Длина 1 вектора: " + Vec1.sqrt());
        System.out.println("Длина 2 вектора: " + Vec2.sqrt());
        System.out.println("Скалярное произведение векторов: " + Vec1.scalarProductOfVectors(Vec2));
        System.out.println("Векторное произведение двух векторов: " + Vec1.vectorProductOfVectors(Vec2).toString());
        System.out.println("Угол между двумя векторами: " + Vec1.angleBetweenTwoVectors(Vec2));
        System.out.println("Сумма двух векторов: " + Vec1.sumOfTwoVectors(Vec2).toString());
        System.out.println("Разность двух векторов: " + Vec1.differenceOfTwoVectors(Vec2).toString());
        System.out.println("Введите количество векторов: ");
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        Vector[] vecArray = Vector.newVector(count);
        System.out.println("Список сгенерированных векторов: ");
        for (Vector i : vecArray) {
            System.out.println(i.toString());
        }
    }
}
