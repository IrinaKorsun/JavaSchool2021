package prikhozhaya;

public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector() {
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public double vectorLen() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(x, 2) + Math.pow(x, 2));
    }

    public double scalarMul(Vector vector) {
        return (x * vector.x + y * vector.y + z * vector.z);
    }

    public Vector vectorMul(Vector vector) {
        double newX = y * vector.z - z * vector.y;
        double newY = z * vector.x - x * vector.z;
        double newZ = x * vector.y - y * vector.x;
        return new Vector(newX, newY, newZ);
    }

    public double cosAngle(Vector vector) {
        return (scalarMul(vector) / (vectorLen() * vector.vectorLen()));
    }

    public Vector addVector(Vector vector) {
        return new Vector((x + vector.x), (y + vector.y), (z + vector.z));
    }

    public Vector subVector(Vector vector) {
        return new Vector((x - vector.x), (y - vector.y), (z - vector.z));
    }

    public static Vector[] arrayVector(int N) {
        Vector[] arrayVector = new Vector[N];
        for (int i = 0; i < N; i++) {
            arrayVector[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return arrayVector;
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
