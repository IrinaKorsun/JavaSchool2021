package Volodin;

import java.util.Scanner;

public class Task3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Управляющая циклом переменная
        String choice;

        // Цикл перезапуска калькулятора
        do {
            System.out.println("Введите числа и операцию для расчет: ");
            double num1 = getDouble();
            char operation = getOperation();
            double num2 = getDouble();
            double result = calc(num1, num2, operation);
            System.out.println("Результат операции: " + result);
            System.out.println("Для повторного расчета нажмите \"y\" и клавишу \"enter\" или любую клавишу для выхода: ");
            choice = scanner.next();
        }
        while (choice.equals("y"));
    }

    // Метод ввода числа и проверки его на допустимые вводимые данные
    public static double getDouble() {
        double num;
        if (scanner.hasNextDouble()) {
            num = scanner.nextDouble();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getDouble();
        }
        return num;
    }

    // Метод ввода операции и проверки его на допустимые вводимые данные
    public static char getOperation() {
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }

    // Метод расчета в зависимости от введенной операции
    public static double calc(double num1, double num2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());//рекурсия
        }
        return result;
    }
}
