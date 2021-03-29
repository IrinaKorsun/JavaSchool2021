package khoroshev;

public final class Vector {
    private final double x;
    private final double y;
    private final double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public double scalarMultiplication(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    public Vector vectorMultiplication(Vector vector) {
        return new Vector(y * vector.z - z * vector.y, z * vector.x -
                x * vector.z, x * vector.y - y * vector.x);
    }

    public double cosine(Vector vector) {
        return scalarMultiplication(vector) / (float)(length() * vector.length());
    }

    public Vector sum(Vector vector) {
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector diff(Vector vector) {
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }

    public static Vector[] getArrayOfRandomVectors(int n) {
        if (n > 0) {
            Vector[] vectors = new Vector[n];
            for (int i = 0; i < n; i++) {
                vectors[i] = new Vector(Math.random() * 200 - 100, Math.random() * 200 - 100,
                        Math.random() * 200 - 100);
            }
            return vectors;
        }
        return new Vector[0];
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