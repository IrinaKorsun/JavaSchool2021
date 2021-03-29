package emelyanov;

import java.util.Scanner;

public class Task3 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Введите первое число - ");
            double number1 = getNumber();
            System.out.print("Введите второе число - ");
            double number2 = getNumber();

            System.out.print("Введите операцию, возможные операции '-, +, /, *, %' - ");
            String operation = scanner.next();
            double result = 0;

            switch (operation) {
                case "-":
                    result = number1 - number2;
                    break;
                case "+":
                    result = number1 + number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
                case "%":
                    result = number1 % number2;
                    break;
                default:
                    System.out.println("Операция не распознана");
            }
            System.out.println("Ответ = " + result);
        }
    }

    private static double getNumber() {
        double number;
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            System.out.println("Ввели не верное число, повторите ввод");
            scanner.next();
            number = getNumber();
        }
        return number;
    }
}
