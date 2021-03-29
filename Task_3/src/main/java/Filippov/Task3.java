// TODO: Need to optimize input numbers proccessing and output formatting from flat code to methods

package Filippov;

import java.io.IOException;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) throws IOException {
        while (true) {
            calc();
        }
    }

    public static void calc() throws IOException {
        Scanner scanner = new Scanner(System.in);
        double number1 = 0.0;
        double number2 = 0.0;
        System.out.println("First number: ");
        if (scanner.hasNextInt() || scanner.hasNextDouble()) {
            number1 = scanner.nextDouble();
        } else {
            System.out.println("Invalid number format");
            System.out.println();
            return;
        }
// Reading an extra "\n"
        scanner.nextLine();
        System.out.println("Math operation (+,-,*,/): ");
        String mathOperation = scanner.nextLine();
        System.out.println("Second number: ");
        if (scanner.hasNextInt() || scanner.hasNextDouble()) {
            number2 = scanner.nextDouble();
        } else {
            System.out.println("Invalid number format");
            System.out.println();
            return;
        }
        System.out.print("Result: ");
        switch (mathOperation.charAt(0)) {
            case (42):
                System.out.println(number1 + " " + mathOperation.charAt(0) + " " + number2 + " = " + (number1 * number2));
                break;
            case (43):
                System.out.println(number1 + " " + mathOperation.charAt(0) + " " + number2 + " = " + (number1 + number2));
                break;
            case (45):
                System.out.println(number1 + " " + mathOperation.charAt(0) + " " + number2 + " = " + (number1 - number2));
                break;
            case (47):
                System.out.println(number1 + " " + mathOperation.charAt(0) + " " + number2 + " = " + (number1 / number2));
                break;
            default:
                System.out.println("Invalid math operation");
                System.out.println();
                return;
        }
        System.out.println();
    }
}

