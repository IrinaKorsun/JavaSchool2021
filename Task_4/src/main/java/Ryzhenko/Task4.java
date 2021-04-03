package Ryzhenko;

public class Task4 {
    public static void main(String[] args) {
        //Первый вектор
        int x1 = 1;
        int y1 = 2;
        int z1 = 3;

        //Второй вектор
        int x2 = 4;
        int y2 = 3;
        int z2 = 2;

        //Длина массива
        int n = 3;

        Vector vector1 = new Vector(x1, y1, z1);
        Vector vector2 = new Vector(x2, y2, z2);
        System.out.println("Вектор 1: " + x1 + " " + y1 + " " + z1);
        System.out.println("Вектор 2: " + x2 + " " + y2 + " " + z2);

        System.out.println("Длина вектора 1: " + vector1.vectorLength());
        System.out.println("Длина вектора 2: " + vector2.vectorLength());
        System.out.println("Скалярное произведение: " + vector1.vectorScalarProduct(vector2));
        System.out.println("Векторное произведение: " + (vector1.vectorProduct(vector2)).printVector());
        System.out.println("Косинус угла между векторами: " + vector1.vectorCos(vector2));
        System.out.println("Сумма векторов: " + vector1.vectorSum(vector2).printVector());
        System.out.println("Разность векторов: " + vector1.vectorDif(vector2).printVector());
        System.out.println("Массив случайных векторов из " + n + " элементов:");
        Vector[] vectors = Vector.vectorRandomArray(n);
        for (int i = 0; i < n; i++) {
            System.out.println(vectors[i].printVector());
        }
    }
}
