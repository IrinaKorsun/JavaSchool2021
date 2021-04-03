package my;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Vector {
    private int x;
    private int y;
    private int z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double calcLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double calcScalar(Vector vec) {
        return x * vec.x + y * vec.y + z * vec.z;
    }

    public Vector multiplyVector(Vector vec) {
        return new Vector(y * vec.z - z * vec.y,
                z * vec.x - x * vec.z,
                x * vec.y - y * vec.x);
    }

    public double calcCosAngle(Vector vec) {
        return calcScalar(vec) / (calcLength() * vec.calcLength());
    }

    public Vector addVector(Vector vec) {
        return new Vector(x + vec.x, y + vec.y, z + vec.z);
    }

    public Vector subtractVector(Vector vec) {
        return new Vector(x - vec.x, y - vec.y, z - vec.z);
    }

    public static Vector[] createArrayOfVectors(int arrayLength) {
        Vector[] vectors = new Vector[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            vectors[i] = new Vector((int) (Math.random() * 10 + 1),
                    (int) (Math.random() * 10 + 1), (int) (Math.random() * 10 + 1));
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public static void main(String[] args) {
        Vector vector1 = new Vector(2, 3, 1);
        Vector vector2 = new Vector(3, 2, 3);
        DecimalFormat df = new DecimalFormat("0.000");

        System.out.println("Вектор 1: " + vector1);
        System.out.println("Вектор 2: " + vector2);
        System.out.println("Длина вектора 1: " + df.format(vector1.calcLength()));
        System.out.println("Длина вектора 2: " + df.format(vector2.calcLength()));
        System.out.println("Скаляное произведение: " + vector1.calcScalar(vector2));
        System.out.println("Вектор произведения векторов: " + vector1.multiplyVector(vector2));
        System.out.println("Угол между векторами: " + df.format(vector1.calcCosAngle(vector2)));
        System.out.println("Вектор сложение векторов: " + vector1.addVector(vector2));
        System.out.println("Вектор вычитания векторов: " + vector1.subtractVector(vector2));
        System.out.println("Массив векторов: " + Arrays.toString(Vector.createArrayOfVectors(4)));
    }
}
