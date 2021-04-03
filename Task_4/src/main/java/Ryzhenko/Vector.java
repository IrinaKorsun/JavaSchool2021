package Ryzhenko;

public class Vector {

    private final int x;
    private final int y;
    private final int z;
    //Конструктор
    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    //Метод, вычисляющий длину вектора
    public double vectorLength () {
        return Math.sqrt(x * x + y * y + z * z);
    }
    //Метод, вычисляющий скалярное произведение
    public double vectorScalarProduct (Vector v) {
        return (x * v.x + y * v.y + z * v.z);
    }
    //Метод, вычисляющий векторное произведение с другим вектором
    public Vector vectorProduct (Vector v) {
        return new Vector (y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
    }
    //Метод, вычисляющий угол между векторами (или косинус угла)
    public double vectorCos (Vector v) {
        return (vectorScalarProduct(v) / Math.abs(this.vectorLength()) * Math.abs(v.vectorLength()));
    }
    //Метод для суммы
    public Vector vectorSum (Vector v) {
        return new Vector (x + v.x, y + v.y, z + v.z);
    }
    //Метод для разности
    public Vector vectorDif (Vector v) {
        return new Vector (x - v.x, y - v.y, z - v.z);
    }
    //статический метод, который принимает целое число N, и возвращает массив
    //случайных векторов размером N.
    public static Vector[] vectorRandomArray (int n) {
        Vector[] vectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector ((int)(Math.random()*10),(int)(Math.random()*10), (int)(Math.random()*10));
        }
        return vectors;
    }
    //Метод для того, чтобы вывести вектор
    public String printVector () {
        return this.x + " " + this.y + " " + this.z;
    }
}