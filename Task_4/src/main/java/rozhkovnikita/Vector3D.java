package rozhkovnikita;

public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double lengthOfVector() {
        return Math.sqrt(Math.pow(getX(), 2) + Math.pow((getY()), 2) + Math.pow((getZ()), 2));
    }

    public static double scalarProduct(Vector3D a, Vector3D b) {
        return a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();
    }

    public static double angleBetweenVectors(Vector3D a, Vector3D b) {
        return ((scalarProduct(a, b)) / (Math.abs(a.lengthOfVector() * b.lengthOfVector())));
    }

    public static Vector3D crossProduct(Vector3D a, Vector3D b) {
        double x = a.getY() * b.getZ() - a.getZ() * b.getY();
        double y = a.getZ() * b.getX() - a.getX() * b.getZ();
        double z = a.getX() * b.getY() - a.getY() * b.getX();
        return new Vector3D(x, y, z);
    }

    public static Vector3D sumVectors(Vector3D a, Vector3D b) {
        double x = a.getX() + b.getX();
        double y = a.getY() + b.getY();
        double z = a.getZ() + b.getZ();
        return new Vector3D(x, y, z);
    }

    public static Vector3D differenceVectors(Vector3D a, Vector3D b) {
        double x = a.getX() - b.getX();
        double y = a.getY() - b.getY();
        double z = a.getZ() - b.getZ();
        return new Vector3D(x, y, z);
    }

    public static Vector3D[] arrayVector(int N) {
        Vector3D[] arrayVector = new Vector3D[N];
        for (int i = 0; i < N; i++) {
            arrayVector[i] = new Vector3D(Math.random(), Math.random(), Math.random());
        }
        return arrayVector;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + ";" + z + "}";
    }
}