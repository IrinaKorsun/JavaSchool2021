package podolyak;

public class Vector {
    private final double x;
    private final double y;
    private final double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double lengthCalculation() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public double scalarCalculation(Vector vector2) {
        return this.x * vector2.x + this.y * vector2.y + this.z * vector2.z;
    }

    public double cosCalculation(Vector vector2) {
        return scalarCalculation(vector2) / (this.lengthCalculation() * vector2.lengthCalculation());
    }

    public Vector vectorCalculation(Vector vector2) {
        return new Vector(
                this.y * vector2.z - this.z * vector2.y,
                this.z * vector2.x - this.x * vector2.z,
                this.x * vector2.y - this.y * vector2.x
        );
    }

    public Vector sumCalculation(Vector vector2) {
        return new Vector(
                this.x + vector2.x,
                this.y + vector2.y,
                this.z + vector2.z
        );
    }

    public Vector subCalculation(Vector vector2) {
        return new Vector(
                this.x - vector2.x,
                this.y - vector2.y,
                this.z - vector2.z
        );
    }

    static public Vector[] createNewVectors(int quantity) {
        Vector[] arrayVectors = new Vector[quantity];
        for (int i = 0; i < quantity; i++) {
            arrayVectors[i] = new Vector(Math.random() * 10, Math.random() + 10, Math.random() * 10);
        }
        return arrayVectors;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + String.format("%.2f", x) +
                ", y=" + String.format("%.2f", y) +
                ", z=" + String.format("%.2f", z) +
                '}';
    }
}
