package Filippov;

public class Task2 {

    public static void main(String[] args) {

        double maxIndex = 0;
        double lowIndex = 1;
        double curIndex = 0;

        double[] myArray = new double[10];
        for (int i = 0; i < myArray.length; i++) {
            curIndex = Math.random();
            if (curIndex > maxIndex) {
                maxIndex = curIndex;
            }
            if (curIndex < lowIndex){
                lowIndex = curIndex;
            }
            myArray[i] = curIndex;
            System.out.println(myArray[i]);
        }

        System.out.println("\n"+ "Lowest "+lowIndex+", Largest "+maxIndex);
    }
}