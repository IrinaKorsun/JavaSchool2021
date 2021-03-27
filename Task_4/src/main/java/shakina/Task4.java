package shakina;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        Vector3D vector = new Vector3D(5, 7, 9);
        Vector3D otherVector = new Vector3D(3, 9, 12);

        System.out.printf("Длина вектора %s равна %.2f \n", vector.toString(), vector.vectorLength());
        System.out.printf("Скалярное произведение векторов %s и %s равно %.2f \n",
                vector.toString(), otherVector.toString(), vector.scalarProduct(otherVector));
        System.out.printf("Векторное произведение векторов %s и %s равно %s \n",
                vector.toString(), otherVector.toString(), vector.vectorProduct(otherVector));
        System.out.printf("Угол между векторами %s и %s равен %.2f \n",
                vector.toString(), otherVector.toString(), vector.angleBetweenVectors(otherVector));
        System.out.printf("Сумма векторов %s и %s равна %s \n",
                vector.toString(), otherVector.toString(), vector.vectorSum(otherVector));
        System.out.printf("Разность векторов %s и %s равна %s \n",
                vector.toString(), otherVector.toString(), vector.vectorDifference(otherVector));
        System.out.printf("Массив случайных векторов размером %d: %s", 5, Arrays.toString(Vector3D.getArrayOfRandomVectors(5)));
    }
}
