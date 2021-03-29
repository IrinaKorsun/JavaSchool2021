package rozhkovnikita;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        Vector3D a = new Vector3D(1, 2, 3);
        Vector3D b = new Vector3D(3, 2, 1);

        //метод, вычисляющий длину вектора.
        System.out.println(a.lengthOfVector());
        //метод, вычисляющий скалярное произведение:
        System.out.println(Vector3D.scalarProduct(a, b));
        //метод, вычисляющий векторное произведение с другим вектором
        System.out.println(Vector3D.crossProduct(a, b));
        //метод, вычисляющий косинус угла
        System.out.println(Vector3D.angleBetweenVectors(a, b));
        //методы суммы векторов
        System.out.println(Vector3D.sumVectors(a, b));
        //методы разности векторов
        System.out.println(Vector3D.differenceVectors(a, b));
        //метод, который принимает целое число N, и возвращает массив
        //случайных векторов размером N.
        System.out.println(Arrays.toString(Vector3D.arrayVector(5)));
    }
}
