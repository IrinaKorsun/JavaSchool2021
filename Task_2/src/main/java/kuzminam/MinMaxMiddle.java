package kuzminam;

import java.lang.reflect.Array;

public class MinMaxMiddle {
    double[] randomNumbersArray;

/*    public double[] arrayFilling(int length){
        double myArray[] = new double[length];
        for (int i = 0; i < length; i++) {
            double a = Math.random();
            myArray[i] = a;
            System.out.println(a);
        }
        return myArray;
    }*/

    public double[] arrayFilling() {
        for (int i = 0; i < randomNumbersArray.length; i++) {
            double a = Math.random();
            randomNumbersArray[i] = a;
//            System.out.println(a);
        }
        return randomNumbersArray;
    }

    public double findMin() {
        double minimum = randomNumbersArray[0];
        for (int i = 1; i < randomNumbersArray.length; i++) {
            if (randomNumbersArray[i] < minimum) {
                minimum = randomNumbersArray[i];
            }
        }
        return minimum;
    }

    public double findMax() {
        double max = randomNumbersArray[0];
        for (int i = 1; i < randomNumbersArray.length; i++) {
            if (randomNumbersArray[i] > max) {
                max = randomNumbersArray[i];
            }
        }
        return max;
    }


    public double findMiddle() {
        double middle = randomNumbersArray[0];
        for (int i = 1; i < randomNumbersArray.length; i++) {
                middle += randomNumbersArray[i];
        }
        middle /= randomNumbersArray.length;
        return middle;
    }

    public MinMaxMiddle(int length) {
        randomNumbersArray = new double[length];
    }

    public static void main(String[] args) {
        int length = 10;
        MinMaxMiddle array = new MinMaxMiddle(length);
        array.arrayFilling();
        System.out.println("Min = " + array.findMin());
        System.out.println("Max = " + array.findMax());
        System.out.println("Middle = " + array.findMiddle());


    }

}


