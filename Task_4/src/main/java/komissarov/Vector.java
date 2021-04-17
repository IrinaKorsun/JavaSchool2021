package komissarov;

public class Vector {
    private int x;
    private int y;
    private int z;


    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double vectorLength() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public int scalarProduct(Vector vector) {
        return this.x * vector.getX() + this.y * vector.getY() + this.z * vector.getZ();
    }

    public Vector vectorСomposition(Vector vector) {
        return new Vector(this.y * vector.getZ() - this.z * vector.getY(),
                          this.z * vector.getX() - this.x * vector.getZ(),
                          this.x * vector.getY() - this.y * vector.getX());
    }

    public double angleBetweenVectors(Vector vector) {
        return scalarProduct(vector) / (Math.abs(vectorLength()) * Math.abs(vector.vectorLength()));
    }

    public Vector vectorSum(Vector vector) {
        return new Vector(this.x + vector.getX(), this.y + vector.getY(), this.z + vector.getZ());
    }

    public Vector vectorDiff(Vector vector) {
        return new Vector(this.x - vector.getX(), this.y - vector.getY(), this.z - vector.getZ());
    }

    public static Vector[] arrayOfVectors(int n) {
        Vector[] arrV = new Vector[n];
        for (int i = 0; i < n; i++) {
            arrV[i] = new Vector(1 + (int) (Math.random() * 1000),
                                 1 + (int) (Math.random() * 1000),
                                 1 + (int) (Math.random() * 1000));
        }

        return arrV;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
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
