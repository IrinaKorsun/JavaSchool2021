package krivko;

import java.text.DecimalFormat;

public class Vector {
    private final double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector[] arrayRandomVectors(int size) {
        int maxNumber = 10;
        Vector[] arrayVector = new Vector[size];
        for (int i = 0; i < size; i++)
            arrayVector[i] = new Vector(Math.random() * maxNumber,
                                        Math.random() * maxNumber,
                                        Math.random() * maxNumber);
        return arrayVector;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalar(Vector vector) {
        return this.x * vector.x + this.y * vector.y + this.z * vector.z;
    }

    public Vector multiply(Vector vector) {
        double i = this.y * vector.z - this.z * vector.y;
        double j = this.z * vector.x - this.x * vector.z;
        double k = this.x * vector.y - this.y * vector.x;
        return new Vector(i, j, k);
    }

    public double angle(Vector vector) {
        return this.scalar(vector) / (this.length() * vector.length());
    }

    public Vector add(Vector vector) {
        return new Vector(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }

    public Vector diff(Vector vector) {
        return new Vector(this.x - vector.x, this.y - vector.y, this.z - vector.z);
    }

    @Override
    public String toString() {
        DecimalFormat f = new DecimalFormat("##");
        return "{" + f.format(x) + ", " + f.format(y) + ", " + f.format(z) + "}";
    }
}
