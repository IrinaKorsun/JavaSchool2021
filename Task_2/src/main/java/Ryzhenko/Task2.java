package Ryzhenko;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {

        double [] array = new double[10];
        fillArray(array);
        maxValue(array);
        minValue(array);
        avgValue(array);

    }
    //Заполнить массив случайным числами
    private static void fillArray(double[] arr){
        System.out.println("Элементы массива:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random();
            System.out.println(arr[i]);
        }
    }
    //вывести максимальное значение
    private static void maxValue(double[] arr){
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("Максимальное значение равно " + max);
    }
    //вывести минимальное значение
    private static void minValue(double[] arr){
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("Минимальное значение равно " + min);
    }
    //вывести среднее значение
    private static void avgValue(double[] arr){
        double avg = 0;
        for (int i = 0; i < arr.length; i++) {
            avg += arr[i];
        }
        avg = avg / arr.length;
        System.out.println("Среднее значение равно " + avg);
    }
}