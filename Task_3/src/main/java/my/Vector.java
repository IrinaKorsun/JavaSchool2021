package my;

public class Vector {

    private double x;
    private double y;
    private double z;

    protected Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /*Длина вектора*/
    protected double getLength() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    /*Скалярное произведение*/
    protected double getScalar(Vector vector) {
        return vector.x * this.x + vector.y * this.y + vector.z * this.z;
    }

    /*Векторное произведение с другим вектором*/
    protected Vector getVectorProuct(Vector vector) {
        return new Vector(
                this.y * vector.z - this.z * vector.y,
                this.z * vector.x - this.x * vector.z,
                this.x * vector.y - this.y * vector.x
        );
    }

    /*Вычисление угла между векторами или косинус угла*/
    protected double getAngel(Vector vector) {
        return (getScalar(vector) / (getLength() * vector.getLength()));
    }

    /*Вычисление суммы*/
    protected Vector getSum(Vector vector) {
        return new Vector((this.x + vector.x), (this.y + vector.y), (this.z + vector.z));
    }

    /*Вычисление разности*/
    protected Vector getDifference(Vector vector) {
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
