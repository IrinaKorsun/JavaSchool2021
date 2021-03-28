package lesnoy;

public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double vectorLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarProizvVec(Vector vector) {
        return (x * vector.x + y * vector.y + z * vector.z);
    }

    public Vector vectorProizvVec(Vector vector) {
        double x1 = y * vector.z - z * vector.y;
        double y1 = z * vector.x - x * vector.z;
        double z1 = x * vector.y - y * vector.x;
        return new Vector(x1, y1, z1);
    }

    public double angleBetweenVect(Vector vector) {
        return (scalarProizvVec(vector) / (vectorLength() * vector.vectorLength()));
    }

    public Vector vectorSum(Vector vector) {
        return new Vector((x + vector.x), (y + vector.y), (z + vector.z));
    }

    public Vector vectorRazn(Vector vector) {
        return new Vector((x - vector.x), (y - vector.y), (z - vector.z));
    }

    public static Vector[] arrayRandVectors(int n) {
        Vector[] arrVector = new Vector[n];
        for (int i = 0; i < arrVector.length; i++) {
            arrVector[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return arrVector;
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + ", " + z + '}';
    }
}

