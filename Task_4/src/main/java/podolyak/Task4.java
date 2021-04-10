package podolyak;

public class Task4 {
    public static void main(String[] args) {

        //Для теста
        Vector vector1 = new Vector(2, 4, 6);
        Vector vector2 = new Vector(3, 8, 10);
        System.out.println("Первый вектор: " + vector1);
        System.out.println("Второй вектор: " + vector2);

        //Длина
        System.out.println("Длина первого вектора: " + String.format("%.2f", vector1.lengthCalculation()));
        System.out.println("Длина второго вектора: " + String.format("%.2f", vector2.lengthCalculation()));

        // Скалярное произведение векторов
        System.out.println("Скалярное произведение первого вектора на второй: " + vector1.scalarCalculation(vector2));

        //Косинус угла между векторами
        System.out.println("Косинус угла между векторами: " + String.format("%.4f", vector1.cosCalculation(vector2)));

        //Векторное произведение
        System.out.println("Векторное произведение первого вектора на второй: " + vector1.vectorCalculation(vector2));

        //Сумма и разность векторов
        System.out.println("Сумма векторов: " + vector1.sumCalculation(vector2));
        System.out.println("Разность первого и второго векторов: " + vector1.subCalculation(vector2));
        System.out.println("Разность второго и первого векторов: " + vector2.subCalculation(vector1));
        //Создание массива векторов
        System.out.println("Массив новых векторов:");
        Vector[] vectors = Vector.createNewVectors(3);
        for (Vector vector : vectors) {
            System.out.println(vector);
        }


    }

}
