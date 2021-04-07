package Filippov;

public class Vector {
    private final double x;
    private final double y;
    private final double z;

    //  Вызов конструктора с параметрами генерирует конкретный вектор
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //  Вызов конструктора без параметров генерирует рандомный вектор
    public Vector() {
        this.x = Math.random();
        this.y = Math.random();
        this.z = Math.random();
    }

    //  Генерируем массив рандомных векторов и возвращаем в виде массива объектов
    public static Vector[] vectorArrayRandomGenerator(int quantity) {
        Vector[] vectorsArray = new Vector[quantity * 3];
        for (int i = 0; i < quantity * 3; i++) {
            vectorsArray[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return vectorsArray;
    }

    //  Векторное произведение возвращает объект вектор
    public Vector vectorMultiplication(Vector vector) {
        return new Vector(this.y * vector.z - this.z * vector.y, this.z * vector.x - this.x * vector.z, this.x * vector.y - this.y * vector.x);

    }

    //  Скалярное произведение
    public double scalarMultiplication(Vector vector) {
        return (this.x * vector.x + this.y * vector.y + this.z * vector.z);
    }

    //  Переопределяем toString
    @Override
    public String toString() {
        return (this.x + ", " + this.y + ", " + this.z);
    }

    //  Длина вектора
    public double vectorLength() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    //  Угол между векторами
    public double vectorAngle(Vector vector) {
        return (this.scalarMultiplication(vector) / (this.vectorLength() * vector.vectorLength()));
    }

    //  Разница векторов
    public Vector vectorSubstraction(Vector vector) {
        return new Vector(this.x - vector.x, this.y - vector.y, this.z - vector.z);
    }

    //  Сумма векторов
    public Vector vectorAddition(Vector vector) {
        return new Vector(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }
}
