package Ryzhenko;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите число 1:");
            while (scanner.hasNextDouble() == false) {
                System.out.println("Ошибка. Введите число!");
                scanner.next();
            }
            double number1 = scanner.nextDouble();
            System.out.println("Введите число 2:");
            while (scanner.hasNextDouble() == false) {
                System.out.println("Ошибка. Введите число!");
                scanner.next();
            }
            double number2 = scanner.nextDouble();
            System.out.println("Введите операцию.\nДоступные операции: + - * /");
            String operation = scanner.next();
            double result = 0;
            switch (operation) {
                case ("+"):
                    result = number1 + number2;
                    System.out.println("Результат сложения равен " + result);
                    break;
                case ("-"):
                    result = number1 - number2;
                    System.out.println("Результат вычитания равен " + result);
                    break;
                case ("*"):
                    result = number1 * number2;
                    System.out.println("Результат умножения равен " + result);
                    break;
                case ("/"):
                    result = number1 / number2;
                    System.out.println("Результат деления равен " + result);
                    break;
                default:
                    System.out.println("Неверная операция");
                    break;
            }
        }
    }
}