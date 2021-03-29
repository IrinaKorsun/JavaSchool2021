/*
Реализация класса, описывающего вектор (в трёхмерном пространстве).
*/
package zhmaylo;

public class Vector {
    //нужно реализовать шаблон "Неизменяемый объект"
    private final double x, y, z;


    //конструктор с параметрами в виде списка координат x, y, z
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //метод, вычисляющий длину вектора
    public double length() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }


    //метод, вычисляющий скалярное произведение
    public double scalarMultipl(Vector vector) {
        return this.x * vector.x + this.y * vector.y + this.z * vector.z;
    }

    //метод, вычисляющий векторное произведение с другим вектором:
    public Vector vectorMultipl(Vector vector) {
        double i = this.y * vector.z - this.z * vector.y;
        double j = this.z * vector.x - this.x * vector.z;
        double k = this.x * vector.y - this.y * vector.x;
        return new Vector(i, j, k);
    }

    //метод, вычисляющий угол между векторами
    public double cosBtwVectors(Vector vector) {
        return this.scalarMultipl(vector) / (this.length() * vector.length());
    }

    //метод для суммы
    public Vector sum(Vector vector) {
        return new Vector(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }

    //метод для разности
    public Vector dif(Vector vector) {
        return new Vector(this.x - vector.x, this.y - vector.y, this.z - vector.z);
    }

    //статический метод, который принимает целое число N, и возвращает массив случайных векторов размером N.
    public static Vector[] generate(int n) {
        Vector[] array = new Vector[n];
        for (int i = 0; i < n; i++) {
            array[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return array;
    }

    //технически необходимый метод перевода вектора в строку
    public String toString() {
        return "{" + this.x + ";" + this.y + ";" + this.z + "}";
    }
}
