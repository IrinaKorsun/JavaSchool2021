package Volodin;

import java.util.Arrays;

public class Task4 {
    public static void main (String [] args) {

        double x, y, z;
        double x1, y1, z1;

        x = 1.5;
        y = 2;
        z = 3;

        x1 = 3;
        y1 = 5;
        z1 = 7;

        Vector3D testVector3D1 = new Vector3D(x, y, z);
        Vector3D testVector3D2 = new Vector3D(x1, y1, z1);

        System.out.println("Метод вычисления длины вектора " + Vector3D.lengthVector(x,y,z));
        System.out.println("Метод вычисления скалярного произведения векторов " + testVector3D1.scalarVector(testVector3D2));
        System.out.println("Метод вычисления векторного произведения с другим вектором " + Arrays.toString(testVector3D1.multVector(testVector3D2)));
        System.out.println("Метод вычисляющий угол между векторами или косинус угла " + testVector3D1.angleVector(testVector3D2));
        System.out.println("Метод суммы двух векторов " + Arrays.toString(testVector3D1.sumVector(testVector3D2)));
        System.out.println("Метод разности двух векторов " + Arrays.toString(testVector3D1.diffVector(testVector3D2)));
        System.out.println("Метод заполнения N-массива случайными данными " + Arrays.toString(Vector3D.randomVector()));
    }
}
