package Filippov;

public class Task2 {

    public static void main(String[] args) {
        int arrSize = 10;
        double maxNumber = 0;
        double lowNumber = 1;
        double averageNumber = 0;
        double[] myArray = new double[arrSize];

        for (int i = 0; i < arrSize; i++) {
            myArray[i] = Math.random();
            if (myArray[i] > maxNumber) {
                maxNumber = myArray[i];
            }
            if (myArray[i] < lowNumber) {
                lowNumber = myArray[i];
            }
            averageNumber += myArray[i];
            System.out.println(myArray[i]);
        }

        System.out.println("\n" + "Lowest " + lowNumber + ", Largest " + maxNumber + ", Average " + averageNumber / arrSize);
    }
}