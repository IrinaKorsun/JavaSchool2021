package mozzherin;

import static mozzherin.Vector.vectors;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(4, 5, 6);
        Vector vector2 = new Vector(3, 5, 7);
        Vector[] arrVector = vectors(10);

        System.out.println("vectorLength " + vector1.vectorLength());
        System.out.println("scalarMult " + vector1.scalarMult(vector2));
        System.out.println("vectorMult " + vector1.vectorMult(vector2));
        System.out.println("cosOfTheAngle " + vector1.cosOfTheAngle(vector2));
        System.out.println("vectorAdd " + vector1.vectorAdd(vector2));
        System.out.println("vectorSub " + vector1.vectorSub(vector2));

        for (Vector vector : arrVector) {
            System.out.println(vector);
        }
    }
}