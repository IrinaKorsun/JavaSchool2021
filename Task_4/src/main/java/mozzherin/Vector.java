package mozzherin;

public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double vectorLength(double x, double y, double z) {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double vectorLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarMult(Vector vector) {
        return x * vector.getX() + y * vector.getY() + z * vector.getZ();
    }

    public Vector vectorMult(Vector vector) {
        return new Vector(y * vector.getZ() - z * vector.getY(),
                z * vector.getX() - x * vector.getZ(),
                x * vector.getY() - y * vector.getX());
    }

    public double cosOfTheAngle(Vector vector) {
        return scalarMult(vector)
                / (vectorLength(x, y, z) * vectorLength(vector.getX(), vector.getY(), vector.getZ()));
    }

    public Vector vectorAdd(Vector vector) {
        return new Vector(x + vector.getX(), y + vector.getY(), z + vector.getZ());
    }

    public Vector vectorSub(Vector vector) {
        return new Vector(x - vector.getX(), y - vector.getY(), z - vector.getZ());
    }

    public static Vector[] vectors(int N){
        Vector[] vectors = new Vector[N];
        for(int i = 0; i < N; i++) {
            vectors[i] = new Vector((int) (Math.random() * 10),
                    (int) (Math.random() * 10),
                    (int) (Math.random() * 10));
        }
        return vectors;
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