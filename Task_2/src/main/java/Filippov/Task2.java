package Filippov;

public class Task2 {

    public static void main(String[] args) {
        int arrSize = 10;
        double maxNumber = 0;
        double lowNumber = 1;
        double curNumber;
        double averageNumber = 0;
        double[] myArray = new double[arrSize];

        for (int i = 0; i < arrSize; i++) {
            curNumber = Math.random();
            if (curNumber > maxNumber) {
                maxNumber = curNumber;
            }
            if (curNumber < lowNumber) {
                lowNumber = curNumber;
            }
            myArray[i] = curNumber;
            averageNumber += curNumber;
            System.out.println(myArray[i]);
        }

        System.out.println("\n" + "Lowest " + lowNumber + ", Largest " + maxNumber + ", Average " + averageNumber / arrSize);
    }
}