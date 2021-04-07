package Volodin;

import java.util.Random;
import java.util.Scanner;

public class Vector3D {

    private double x, y, z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Метод расчета длины вектора
     * @return
     */
    public static double lengthVector (double x, double y, double z) {
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Метод расчета скалярного произведения двух векторов
     * @param anotherVector3D
     * @return
     */
    public double scalarVector(Vector3D anotherVector3D) {
        double scalar = 0;

        for (int i = 0; i < 1; i++){
            scalar = (x * anotherVector3D.x) + (y * anotherVector3D.y) + (z * anotherVector3D.z);
        }
        return scalar;
    }

    /**
     * Метод вычисляющий векторное произведение с другим вектором
     * @param anotherVector3D
     * @return
     */
    public double[] multVector (Vector3D anotherVector3D) {
        double[] mult;
        double mult1;
        double mult2;
        double mult3;

        mult1 = (y * anotherVector3D.z) - (z * anotherVector3D.y);
        mult2 = (z * anotherVector3D.x) - (x * anotherVector3D.z);
        mult3 = (x * anotherVector3D.y) - (y * anotherVector3D.x);

        mult = new double[3];
        mult[0] = mult1;
        mult[1] = mult2;
        mult[2] = mult3;

        return mult;
    }

    /**
     * Метод вычисляющий угол между векторами(или косинус угла)
     * @param anotherVector3D
     * @return
     */
    public double angleVector(Vector3D anotherVector3D) {
        double angle;

        Vector3D vec1 = new Vector3D(anotherVector3D.x,y,z);

        angle = (scalarVector(vec1)) / ((Math.abs(lengthVector(x,y,z)) * Math.abs(lengthVector(anotherVector3D.x,y,z))));

        return angle;
    }

    /**
     * Метод суммы двух векторов
     * @param anotherVector3D
     * @return
     */
    public double[] sumVector(Vector3D anotherVector3D) {
        double[] sum;
        double sum1;
        double sum2;
        double sum3;

        sum1 = x + anotherVector3D.x;
        sum2 = y + anotherVector3D.y;
        sum3 = z + anotherVector3D.z;

        sum = new double[3];
        sum[0] = sum1;
        sum[1] = sum2;
        sum[2] = sum3;

        return sum;
    }

    /**
     * Метод разности двух векторов
     * @param anotherVector3D
     * @return
     */
    public double[] diffVector(Vector3D anotherVector3D) {
        double[] diff;
        double diff1;
        double diff2;
        double diff3;

        diff1 = x - anotherVector3D.x;
        diff2 = y - anotherVector3D.y;
        diff3 = z - anotherVector3D.z;

        diff = new double[3];
        diff[0] = diff1;
        diff[1] = diff2;
        diff[2] = diff3;

        return diff;
    }

    /**
     * Метод, который принимает целое число N, и возвращает массив
     * случайных векторов размером N
     * @return
     */
    public static int[] randomVector() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите N: " );

        int n;
        int[] array;

        n = input.nextInt();
        array = new int[n];

        Random random = new Random();

        for (int i = 0; i < array.length; i++){

            array[i] = random.nextInt();
        }
        return array;
    }
}
