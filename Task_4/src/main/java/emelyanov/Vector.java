package emelyanov;

public class Vector {

    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /*Длина вектора*/
    public double getLength() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    /*Скалярное произведение*/
    public double getScalar(Vector vector) {
        return vector.x * this.x + vector.y * this.y + vector.z * this.z;
    }

    /*Векторное произведение с другим вектором*/
    public Vector getVectorProduct(Vector vector) {
        return new Vector(
                this.y * vector.z - this.z * vector.y,
                this.z * vector.x - this.x * vector.z,
                this.x * vector.y - this.y * vector.x
        );
    }

    /*Вычисление угла между векторами или косинус угла*/
    public double getAngle(Vector vector) {
        return (getScalar(vector) / (getLength() * vector.getLength()));
    }

    /*Вычисление суммы*/
    public Vector getSum(Vector vector) {
        return new Vector((this.x + vector.x), (this.y + vector.y), (this.z + vector.z));
    }

    /*Вычисление разности*/
    public Vector getDifference(Vector vector) {
        return new Vector((this.x - vector.x), (this.y - vector.y), (this.z - vector.z));
    }

    /*Массив случайных векторов*/
    public static Vector[] getArrayRandomVectors(int n) {
        Vector[] vec = new Vector[n];
        for (int i = 0; i < n; i++) {
            vec[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return vec;
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
