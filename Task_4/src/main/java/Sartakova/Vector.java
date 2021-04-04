package Sartakova;

public class Vector {
    //Реализация шаблона "Неизменяемый объект"
    final double x, y, z;

    //Конструктор класса с параметрами x, y, z "
    public Vector(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //Вычисление длины вектора"
    public double sqrt() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    //Вычисление скалярного произведения векторов"
    public double scalarProductOfVectors(Vector vector) {
        return this.x * vector.x + this.y * vector.y + this.z + vector.z;
    }

    //Вычисление векторного произведения"
    public Vector vectorProductOfVectors(Vector vector) {
        double a = this.y * vector.z - this.z * vector.y;
        double b = this.z * vector.x - this.x * vector.z;
        double c = this.x * vector.y - this.y * vector.x;
        return new Vector(a, b, c);
    }
    //Вычисление угла между двумя векторами"
    public double angleBetweenTwoVectors(Vector vector) {
        return scalarProductOfVectors(vector) / (sqrt() * vector.sqrt());
    }
    //Вычисление суммы двух векторов"
    public Vector sumOfTwoVectors(Vector vector) {
        return new Vector(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }
    //Вычисление разности двух векторов"
    public Vector differenceOfTwoVectors(Vector vector) {
        return new Vector(this.x - vector.x, this.y - vector.y, this.z - vector.z);
    }
    //метод, возвращающий массив случайных векторов размером N
    public static Vector[] newVector(int n) {
        Vector[] vectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector((Math.random() *10), (Math.random() *10), (Math.random() *10));
        }
        return vectors;
    }
    //метод, для перевода вектора в строку
    @Override
    public String toString() {
        return "{ " + x + ", " + y + ", " + z + " }";

    }
}
