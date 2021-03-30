package berezin;

public final class Vector3D {

    private final double x;
    private final double y;
    private final double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double getScalarProductOfVectors(Vector3D vector) {
        return x * vector.getX() + y * vector.getY() + z * vector.getZ();
    }

    public Vector3D getVectorProduct(Vector3D vector) {
        return new Vector3D(y * vector.getZ() - z * vector.getY(), z * vector.getX() - x * vector.getZ(), x * vector.getY() - y * vector.getX());
    }

    public double getCosineAngle(Vector3D vector) {
        return getScalarProductOfVectors(vector) / (getLength() * vector.getLength());
    }

    public Vector3D getSumOfVectors(Vector3D vector) {
        return new Vector3D(x + vector.getX(), y + vector.getY(), z + vector.getZ());
    }

    public Vector3D getDifferenceVector(Vector3D vector) {
        return new Vector3D(x - vector.getX(), y - vector.getY(), z - vector.getZ());
    }

    public static Vector3D[] getRandomVectors(int n) {
        Vector3D[] arrayVector = new Vector3D[n];
        for (int i = 0; i < arrayVector.length; i++) {
            arrayVector[i] = new Vector3D(Math.random() * 100, Math.random() * 100, Math.random() * 100);
        }
        return arrayVector;
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
        return "( " +
                 + x +
                " , " + y +
                " , " + z +
                " )";
    }
}
