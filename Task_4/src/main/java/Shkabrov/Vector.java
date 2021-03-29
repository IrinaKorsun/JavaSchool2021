package Shkabrov;

import java.text.DecimalFormat;

public final class Vector {
    private final double x;
    private final double y;
    private final double z;

    Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double calculateVectorLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double calculateScalarProductOfVectors(Vector secondVector) {
        return getX() * secondVector.getX() + getY() * secondVector.getY() + getZ() * secondVector.getZ();
    }

    public Vector calculateCrossProductOfVectors(Vector secondVector) {
        return new Vector(getY() * secondVector.getZ() - getZ() * secondVector.getY(),
                getZ() * secondVector.getX() - getX() * secondVector.getZ(),
                getX() * secondVector.getY() - getY() * secondVector.getX());
    }

    public double calculateAngleBetweenVectors(Vector secondVector) {
        return calculateScalarProductOfVectors(secondVector) / (this.calculateVectorLength() *
                secondVector.calculateVectorLength());
    }

    public Vector calculateSumOfVectors(Vector secondVector) {
        return new Vector(getX() + secondVector.getX(), getY() + secondVector.getY(), getZ()
                + secondVector.getZ());
    }

    public Vector calculateDifferenceOfVectors(Vector secondVector) {
        return new Vector(getX() - secondVector.getX(), getY() - secondVector.getY(), getZ()
                - secondVector.getZ());
    }

    public static Vector[] returnArrayOfRandomVectors(int N) {
        Vector[] arrayOfRandomVectors = new Vector[N];
        for (int i = 0; i < arrayOfRandomVectors.length; i++) {
            arrayOfRandomVectors[i] = new Vector(calculateRandomNumber(0, 10), calculateRandomNumber(0, 10),
                    calculateRandomNumber(0, 10));
        }
        return arrayOfRandomVectors;
    }

    public static double calculateRandomNumber(int minValue, int maxValue) {
        return minValue + Math.random() * maxValue; // граничные значения не включены в диапазон
    }

    public static void main(String[] args) {
        Vector firstVector = new Vector(1, 2, 3);
        Vector secondVector = new Vector(2, 3, 4);
        Vector resultVector = new Vector(0, 0, 0);
        DecimalFormat df = new DecimalFormat("#.####");

        System.out.println("Первый вектор ( " + firstVector.getX() + "; " + firstVector.getY() + "; "
                + firstVector.getZ() + " )");
        System.out.println("Второй вектор ( " + secondVector.getX() + "; " + secondVector.getY() + "; "
                + secondVector.getZ() + " )");

        System.out.println("Длина первого вектора: " + firstVector.calculateVectorLength());
        System.out.println("Длина второго вектора: " + secondVector.calculateVectorLength());

        resultVector = firstVector.calculateSumOfVectors(secondVector);
        System.out.println("Сумма первого и второго векторов ( " + resultVector.getX() + "; " + resultVector.getY()
                + "; " + resultVector.getZ() + " )");

        resultVector = firstVector.calculateDifferenceOfVectors(secondVector);
        System.out.println("Разность первого и второго векторов ( " + resultVector.getX() + "; " + resultVector.getY()
                + "; " + resultVector.getZ() + " )");

        System.out.println("Скалярное произведение первого и второго векторов: "
                + firstVector.calculateScalarProductOfVectors(secondVector));

        resultVector = firstVector.calculateCrossProductOfVectors(secondVector);
        System.out.println("Векторное произведение первого и второго векторов ( " + resultVector.getX() + "; "
                + resultVector.getY() + "; " + resultVector.getZ() + " )");

        System.out.println("Угол между первым и вторым вектором: "
                + df.format(firstVector.calculateAngleBetweenVectors(secondVector)));


        Vector[] arrayOfRandomVectors = Vector.returnArrayOfRandomVectors(5);
        System.out.println("===== Массив векторов =====");
        for (Vector currentVector : arrayOfRandomVectors) {
            System.out.println("( " + df.format(currentVector.getX()) + "; " +
                    df.format(currentVector.getY()) + "; " +
                    df.format(currentVector.getZ()) + " )");
        }
    }
}
