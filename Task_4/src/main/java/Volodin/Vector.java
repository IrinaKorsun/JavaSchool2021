package Volodin;

import java.util.Random;
import java.util.Scanner;

public class Vector {

    private double[] vector;

    public Vector(double[] vector) {
        this.vector = vector;
    }

    /**
     * Метод расчета длины вектора
     * @return
     */
    public double lengthVector (double[] vector) {
        double sqrt = 0;

        for (int i = 0; i < vector.length; i++){
            sqrt += vector[i] * vector[i];
        }
        return (Math.sqrt(sqrt));
    }

    /**
     * Метод расчета скалярного произведения двух векторов
     * @param anotherVector
     * @return
     */
    public double scalarVector(Vector anotherVector) {
        double scalar = 0;

        for (int i = 0; i < vector.length; i++){
            scalar += vector[i] * anotherVector.vector[i];
        }
        return (scalar);
    }

    /**
     * Метод вычисляющий векторное произведение с другим вектором
     * @param anotherVector
     * @return
     */
    public double[] multVector (Vector anotherVector) {
        double[] mult;
        double mult1;
        double mult2;
        double mult3;

        mult1 = vector[1] * anotherVector.vector[2] -  vector[2] * anotherVector.vector[1];
        mult2 = vector[2] * anotherVector.vector[0] -  vector[0] * anotherVector.vector[2];
        mult3 = vector[0] * anotherVector.vector[1] -  vector[1] * anotherVector.vector[0];

        mult = new double[3];
        mult[0] = mult1;
        mult[1] = mult2;
        mult[2] = mult3;

        return mult;
    }

    /** Метод вычисляющий угол между векторами(или косинус угла
     *
     */
    public double angleVector(Vector anotherVector) {
        double angle;

        Vector vec1 = new Vector(anotherVector.vector);

        angle = (scalarVector(vec1)) / ((Math.abs(lengthVector(vector)) * Math.abs(lengthVector(anotherVector.vector))));

        return angle;

    }

    /** Метод суммы двух векторов
     *
     */
    public double[] sumVector(Vector anotherVector) {
        double[] sum;
        double sum1;
        double sum2;
        double sum3;

        sum1 = vector[0] + anotherVector.vector[0];
        sum2 = vector[1] + anotherVector.vector[1];
        sum3 = vector[2] + anotherVector.vector[2];

        sum = new double[3];
        sum[0] = sum1;
        sum[1] = sum2;
        sum[2] = sum3;

        return sum;
    }

    /** Метод разности двух векторов
     *
     */
    public double[] diffVector(Vector anotherVector) {
        double[] diff;
        double diff1;
        double diff2;
        double diff3;

        diff1 = vector[0] - anotherVector.vector[0];
        diff2 = vector[1] - anotherVector.vector[1];
        diff3 = vector[2] - anotherVector.vector[2];

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

        for (int i = 0; i < array.length; i++){

            Random rand = new Random();
            int randomNum = rand.nextInt();

            array[i] = randomNum;
        }
        return array;
    }
}
