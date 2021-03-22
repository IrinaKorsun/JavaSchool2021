package bakunov;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#.##");

        double[] mass = new double[40];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = Math.random();
        }

        System.out.println("Average = " + df.format(Arrays.stream(mass).average().getAsDouble()));
        System.out.println("Min = " + df.format(Arrays.stream(mass).min().getAsDouble()));
        System.out.println("Max = " + df.format(Arrays.stream(mass).max().getAsDouble()));
    }
}
