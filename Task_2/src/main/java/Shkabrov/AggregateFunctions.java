package Shkabrov;

import java.text.DecimalFormat;

public class AggregateFunctions
{
    public static void main(String[] args)
    {
        double[] randomNumbers = new double[10];
        double minValue;
        double maxValue;
        double avgValue;
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println("Array with random values:");
        for (int i = 0; i < randomNumbers.length; i++)
        {
            randomNumbers[i] = calculateRandomNumber(0, 10);
            System.out.print("|" + df.format(randomNumbers[i]) + "| ");
        }
        System.out.print("\n");
        minValue = findMinimum(randomNumbers);
        maxValue = findMaximum(randomNumbers);
        avgValue = findAverage(randomNumbers);
        System.out.format("Minimum value: " + df.format(minValue) +"; Maximum value: " + df.format(maxValue)
                + "; Average value: " + df.format(avgValue) + ";");
    }

    public static double calculateRandomNumber(int minValue, int maxValue)
    {
        return minValue + Math.random() * maxValue; // граничные значения не включены в диапазон
    }

    public static double findMinimum(double[] entryArray)
    {
        double min = entryArray[0];
        for (double currentNumber: entryArray)
        {
            if(min > currentNumber)
            {
                min = currentNumber;
            }
        }
        return min;
    }

    public static double findMaximum(double[] entryArray)
    {
        double max = entryArray[0];
        for (double currentNumber: entryArray)
        {
            if(max < currentNumber)
            {
                max = currentNumber;
            }
        }
        return max;
    }

    public static double calculateSum(double[] entryArray)
    {
        double sum = 0;
        for (double currentNumber: entryArray)
        {
            sum += currentNumber;
        }
        return sum;
    }

    public static double findAverage(double[] entryArray)
    {
        return calculateSum(entryArray) / entryArray.length;
    }
}
