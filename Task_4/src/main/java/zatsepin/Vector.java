package zatsepin;

import java.util.concurrent.ThreadLocalRandom;

public class Vector {

    private final double x;
    private final double y;
    private final double z;

    static public Vector[] getArrayOfRandomVectors(int arraySize) {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        Vector[] vectors = new Vector[arraySize];
        for (int i = 0; i < arraySize; i++) {
            vectors[i] = new Vector(rand.nextDouble(100), rand.nextDouble(100), rand.nextDouble(100));
        }
        return vectors;
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double lengthOfVector() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarProduct(Vector anotherVector) {
        return ((x * anotherVector.getX()) + (y * anotherVector.getY()) + (z * anotherVector.getZ()));
    }

    public Vector crossProduct(Vector anotherVector) {
        return new Vector(y * anotherVector.getZ() - z * anotherVector.getY(),
                z * anotherVector.getX() - x * anotherVector.getZ(),
                x * anotherVector.getY() - y * anotherVector.getX());
    }

    public double cosBetweenVectors(Vector anotherVector) {
        return (scalarProduct(anotherVector) / (lengthOfVector() * anotherVector.lengthOfVector()));
    }

    public Vector sumOfVectors(Vector anotherVector) {
        return new Vector(x + anotherVector.getX(), y + anotherVector.getY(), z + anotherVector.getZ());
    }

    public Vector diffOfVectors(Vector anotherVector) {
        return new Vector(x - anotherVector.getX(), y - anotherVector.getY(), z - anotherVector.getZ());
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

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
