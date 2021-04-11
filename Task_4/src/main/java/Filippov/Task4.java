package Filippov;

public class Task4 {
    public static void main(String[] args) {
        Vector vector1 = new Vector(1, 2, 3);
        Vector vector2 = new Vector(0, 2, 5);
        System.out.println("Вектор 1: " + vector1.toString());
        System.out.println("Вектор 2: " + vector2.toString());
        System.out.println();
        System.out.println("Длина вектора 1 = " + vector1.vectorLength());
        System.out.println("Скалярное произведение = " + vector1.scalarMultiplication(vector2));
        System.out.println("Векторное произведение = " + vector1.vectorMultiplication(vector2).toString());
        System.out.println("Угол между векторами = " + vector1.vectorAddition(vector2).toString());
        System.out.println("Разница векторов = " + vector1.vectorSubstraction(vector2).toString());
        System.out.println();
        System.out.println("Массив векторов: ");
        Vector[] vectorsArray = Vector.vectorArrayRandomGenerator(3);
        for (Vector vector : vectorsArray) {
            System.out.println(vector.toString());
        }
    }
}