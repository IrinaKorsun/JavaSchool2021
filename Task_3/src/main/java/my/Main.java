package my;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        double a;
        double b;
        char operation;
        double result;
        System.out.println("Введите числа в виде: a+b/a-b/a*b/a:b ");

        while (s.hasNext()) {
            if (s.hasNextDouble()) {
                a = s.nextDouble();
            } else {
                printError();
                continue;
            }
            if (s.hasNext("[+-/*/]")) {
                operation = s.next().charAt(0);
            } else {
                printError();
                continue;
            }
            if (s.hasNextDouble()) {
                b = s.nextDouble();
            } else {
                printError();
                continue;
            }

            switch (operation) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    result = a / b;
                    break;
                default:
                    result = 0;
            }
            System.out.println("Результат =  " + result);
        }
    }

    private static void printError() {
        System.out.println("Ошибка при вводе!");
        s.next();
    }
}
