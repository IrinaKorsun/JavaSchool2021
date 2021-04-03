package rozhkovdima;

public class Task4 {
    public static void main(String[] args) {

        Vector3D vectorA = new Vector3D(1, 2, -3);
        Vector3D vectorB = new Vector3D(3, -2, 1);
        System.out.format("A vector's axis is %s.\n", vectorA);
        System.out.format("B vector's axis is %s.\n", vectorB);
        System.out.format("A vector's length is %s.\n", vectorA.getModule());
        System.out.format("B vector's length is %s.\n", vectorB.getModule());
        System.out.format("The sum of these vectors is %s.\n", vectorA.getAddition(vectorB));
        System.out.format("The subtraction of these vectors is %s.\n", vectorA.getSubtraction(vectorB));
        System.out.format("The scalar product of these vectors is %s.\n", vectorA.getScalar(vectorB));
        System.out.format("The vector product of these vectors is %s.\n", vectorA.getVector(vectorB));

    }
}
