package podolyak;

import java.util.Scanner;

public class Calculator {
    private double firstNumber;
    private double secondNumber;
    private double result;
    private char action;
    static boolean flagQuit = false;

    public static void main(String[] args) {

        while (!flagQuit) {
            boolean flagInput = false;
            Calculator calculator = new Calculator();
            Scanner scanner = new Scanner(System.in);

            while (!flagInput) {
                System.out.println("Введите первое число:");
                try {
                    calculator.firstNumber = Double.parseDouble(scanner.next());
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат, введите все данные снова");
                    continue;
                }
                System.out.println("Введите действие:");
                if (scanner.hasNext("[+-/*/]")) {
                    calculator.action = scanner.next().charAt(0);
                } else {
                    System.out.println("Неверный формат, введите все данные снова");
                scanner.next();
                    continue;
                }
                System.out.println("Введите второе число:");
                try {
                    calculator.secondNumber = Double.parseDouble(scanner.next());
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат, введите все данные снова");
                    continue;
                }
                flagInput = true;
            }

            if (calculator.action == '+') {
                calculator.result = calculator.firstNumber + calculator.secondNumber;
            }
            if (calculator.action == '-') {
                calculator.result = calculator.firstNumber - calculator.secondNumber;
            }
            if (calculator.action == '*') {
                calculator.result = calculator.firstNumber * calculator.secondNumber;
            }
            if (calculator.action == '/') {
                calculator.result = calculator.firstNumber / calculator.secondNumber;
            }

            System.out.println("Выражение равно: " + calculator.result);
            System.out.println("Для выхода нажмите \" q \", для продолжения - любой символ.");
            flagQuit = scanner.nextLine().equalsIgnoreCase("q");
        }
    }
}
