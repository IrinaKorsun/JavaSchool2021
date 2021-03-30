package berezin;

public class Main {

    public static void main(String[] args) {
        Vector3D firstVector = new Vector3D(0, 3, 4);
        Vector3D secondVector = new Vector3D(1, 2, 3);
        int n = 5;
        System.out.println("Первый вектор: " + firstVector.toString());
        System.out.println("Второй вектор: " + secondVector.toString());
        System.out.println("Длина первого вектора: " + firstVector.getLength());
        System.out.println("Длина второго вектора: " + secondVector.getLength());
        System.out.println("Скалярное произведение равно: " + firstVector.getScalarProductOfVectors(secondVector));
        System.out.println("Вектор, полученный при векторном произведении: " + firstVector.getVectorProduct(secondVector).toString());
        System.out.println("Косинус угла между векторами: " + firstVector.getCosineAngle(secondVector));
        System.out.println("Разность первого и второго вектора: " + firstVector.getDifferenceVector(secondVector).toString());
        System.out.println("Сумма первого и второго вектора: " + firstVector.getSumOfVectors(secondVector).toString());
        System.out.println("Сгенерированные вектора: ");
        for(Vector3D vector: Vector3D.getRandomVectors(5)){
            System.out.println(vector.toString());
        }
    }
}
