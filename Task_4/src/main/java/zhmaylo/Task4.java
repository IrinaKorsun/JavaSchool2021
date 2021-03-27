package zhmaylo;


public class Task4 {
    public static void main(String[] args) {

        Vector vec = new Vector(1, 2, 3);
        Vector vec1 = new Vector(3, 2, 1);

        System.out.println("Создали обьект класса Vector: " + vec);
        System.out.println("Длинна нашего вектора: " + vec.length());
        System.out.println("Векторное умножение двух векторов: " + vec.vectorMultipl(vec1));
        System.out.println("Скалярное произведение двух: " + vec.scalarMultipl(vec1));
        System.out.println("Cos угла между векторами: " + vec.cosBtwVectors(vec1));
        System.out.println("Сумма векторов: " + vec.sum(vec1));
        System.out.println("Разность векторов: " + vec.dif(vec1));
        Vector[] vecArray = Vector.generate(5);
        System.out.println("Список сгенерированных векторов: ");
        for (Vector i: vecArray) System.out.println(i);

    }
}
