package shakina;

public final class Vector3D {
    private final int x, y ,z;

    public Vector3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double vectorLength() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public double scalarProduct(Vector3D otherVector3D) {
        return x * otherVector3D.x + y * otherVector3D.y + z * otherVector3D.z;
    }

    public Vector3D vectorProduct(Vector3D otherVector3D) {
        return new Vector3D(y * otherVector3D.z - z * otherVector3D.y,
                z * otherVector3D.x - x * otherVector3D.z,
                x * otherVector3D.y - y * otherVector3D.x);
    }

    public double angleBetweenVectors(Vector3D otherVector3D) {
        return scalarProduct(otherVector3D) / (vectorLength() * otherVector3D.vectorLength());
    }

    public Vector3D vectorSum(Vector3D otherVector3D) {
        return new Vector3D(x + otherVector3D.x, y + otherVector3D.y, z + otherVector3D.z);
    }

    public Vector3D vectorDifference(Vector3D otherVector3D) {
        return new Vector3D(x - otherVector3D.x, y - otherVector3D.y, z - otherVector3D.z);
    }

    public static Vector3D[] getArrayOfRandomVectors(int n) {
        Vector3D[] arrayVectors3D = new Vector3D[n];
        for (int i = 0; i < n; i++) {
            Vector3D vector3D = new Vector3D((int) (Math.random() * 20), (int)(Math.random() * 50), (int) (Math.random() * 40));
            arrayVectors3D[i] = vector3D;
        }
        return arrayVectors3D;
    }

    @Override
    public String toString() {
        return "Vector3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
