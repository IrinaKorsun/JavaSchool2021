package zatsepin;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        double result;
        double first;
        double second;
        char operator;

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a simple arithmetic expression, " +
                    "where numbers and operator are separated by spaces, " +
                    "for example 23 + 11: ");

            if (sc.hasNextDouble()) {
                first = sc.nextDouble();
            } else {
                System.out.println("You entered incorrect expression!");
                continue;
            }
            if (sc.hasNext("[+-/*/]")) {
                operator = sc.next().charAt(0);
            } else {
                System.out.println("You entered incorrect expression!");
                continue;
            }
            if (sc.hasNextDouble()) {
                second = sc.nextDouble();
            } else {
                System.out.println("You entered incorrect expression!");
                continue;
            }
            switch (operator) {
                case '+':
                    result = first + second;
                    break;
                case '-':
                    result = first - second;
                    break;
                case '/':
                    result = first / second;
                    break;
                case '*':
                    result = first * second;
                    break;
                default:
                    result = 0;
            }
            System.out.println("Result is " + result);
        }
    }
}
