package galuza;


import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input;

        while (true) {
            System.out.println("\nThe calculator performs the simplest operations with two decimal numbers: \n" +
                    "addition +, subtraction -, multiplication *, division /, obtaining remainder from division % are available from the operations.\n" +
                    "If you want close application enter command stop. \n" +
                    "Enter the first value separated by a space,\n" +
                    "then the operation and then the second value in the following format: <a> <answer> <b> :");

            String string = scanner.nextLine();
            input = string.split(" ");

            if (input[0].equals("stop")) {
                scanner.close();
                System.out.println("Program is stopped");
                break;
            }

            double a = Double.parseDouble(input[0]);
            String answer = input[1];
            double b = Double.parseDouble(input[2]);

            if (answer.equals("+")) {
                System.out.println("Sum of values " + a + " and " + b + " is " + (a + b));
            }
            else if (answer.equals("-")) {
                System.out.println("Subtraction of values " + a + " and " + b + " is " + (a - b));
            }
            else if (answer.equals("*")) {
                System.out.println("Multiplication of values " + a + " and " + b + " is " + (a * b));
            }
            else if (answer.equals("/")) {
                System.out.println("Division of values " + a + " and " + b + " is " + (a / b));
            }
            else if (answer.equals("%")) {
                System.out.println("Remainder of the division " + a + " and " + b + " is " + (a % b));
            }
            else {
                System.out.println("Incorrect answer operation");
            }
        }
    }
}
