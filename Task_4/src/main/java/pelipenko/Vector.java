package pelipenko;

public class Vector {
    final double x, y, z;

    public Vector(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double sqrt() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarMultiply(Vector vector) {
        return this.x * vector.x + this.y * vector.y + this.z + vector.z;
    }

    public Vector vectorsMultiply(Vector vector) {
        double a = this.y * vector.z - this.z * vector.y;
        double b = this.z * vector.x - this.x * vector.z;
        double c = this.x * vector.y - this.y * vector.x;
        return new Vector(a, b, c);
    }

    public double angles(Vector vector) {
        return scalarMultiply(vector) / (sqrt() * vector.sqrt());
    }

    public Vector sumVectors(Vector vector) {
        return new Vector(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }

    public Vector subVectors(Vector vector) {
        return new Vector(this.x - vector.x, this.y - vector.y, this.z - vector.z);
    }

    public static Vector[] newVector(int n) {
        Vector[] vectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector((int)(Math.random() * 10), (int)(Math.random() * 10), (int)(Math.random() * 10));
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "{ " + x + ", " + y + ", " + z + " }";

    }
}
