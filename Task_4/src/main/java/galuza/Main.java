package galuza;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector3D vector1 = new Vector3D(3.6, 5.8, - 4.5);
        Vector3D vector2 = new Vector3D(- 5.45, 9.23, 1.57);

        System.out.println("Abs value of the vector " + vector1 + " is " + vector1.absValue());
        System.out.println("Abs value of the vector " + vector2 + " is " + vector2.absValue());

        System.out.println("Scalar prod of vectors "  + vector1 + " and " + vector2 +
                " is " + vector1.scalarProd(vector2));
        System.out.println("Vector prod of vectors "  + vector1 + " and " + vector2 +
                " is " + vector1.vectorProd(vector2));

        System.out.println("Angle between vectors " + vector1 + " and " + vector2 +
                " is " + vector1.angle(vector2, "rad") + " rad " +
                " or " + vector1.angle(vector2, "grad") + " grad");

        System.out.println("Sum of vectors " + vector1 + " and " + vector2 + " is " + vector1.sum(vector2));
        System.out.println("Difference of vectors " + vector1 + " and " + vector2 + " is " + vector1.diff(vector2));

        System.out.println("An array filled with vectors with random components:");
        System.out.println(Arrays.toString(vector1.randomVectors(3)));
    }
}
