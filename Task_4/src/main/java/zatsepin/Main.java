package zatsepin;

public class Main {

    public static void main(String[] args) {

        Vector vector1 = new Vector(1, 2, 3);
        Vector vector2 = new Vector(4, 5, 6);

        System.out.println("Created vector1: " + vector1);
        System.out.println("Created vector2: " + vector2);
        System.out.println("Length of vector1: " + vector1.lengthOfVector());
        System.out.println("Length of vector2: " + vector2.lengthOfVector());
        System.out.println("Scalar product of vector1 and vector2: " + vector1.scalarProduct(vector2));
        System.out.println("Cross product of vector1 and vector2: " + vector1.crossProduct(vector2));
        System.out.println("Cosinus between vector1 and vector2: " + vector1.cosBetweenVectors(vector2));
        System.out.println("Sum of vector1 and vector2: " + vector1.sumOfVectors(vector2));
        System.out.println("Difference of vector1 and vector2: " + vector1.diffOfVectors(vector2));

        Vector[] vectors = Vector.getArrayOfRandomVectors(5);
        for (Vector vector : vectors) {
            System.out.println("Random generated vector: " + vector);
        }
    }
}
