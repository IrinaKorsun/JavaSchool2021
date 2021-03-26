package prikhozhaya;

import static prikhozhaya.Vector.arrayVector;

public class Task4 {
    public static void main(String[] args) {
        Vector vector1 = new Vector(3, 4, 6);
        Vector vector2 = new Vector(4, 6, 1);

        System.out.println("\nИсходные данные\n" + vector1.toString() + "\n" + vector2.toString());

        /**Mетод, вычисляющий длину вектора**/
        System.out.println("\nMетод, вычисляющий длину вектора\n" + vector1.vectorLen());

        /**Метод, вычисляющий скалярное произведение**/
        System.out.println("\nМетод, вычисляющий скалярное произведение\n" + vector1.scalarMul(vector2));

        /**Метод, вычисляющий векторное произведение с другим вектором**/
        System.out.println("\nМетод, вычисляющий векторное произведение с другим вектором\n" + vector1.vectorMul(vector2).toString());

        /**Метод, вычисляющий угол между векторами (или косинус угла)**/
        System.out.println("\nМетод, вычисляющий угол между векторами (или косинус угла)\n" + vector1.cosAngle(vector2));

        /**Метод для суммы**/
        System.out.println("\nМетод для суммы\n" + vector1.addVector(vector2).toString());

        /**Метод для разности**/
        System.out.println("\nМетод для разности\n" + vector1.subVector(vector2).toString());

        /**Массив случайных векторов**/
        System.out.println("\nМассив случайных векторов");
        Vector [] arrayVector = arrayVector(10);
        for (Vector vector: arrayVector){
            System.out.println(vector.toString());
        }

    }
}
