package komissarov;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //инициализируем сканер
        while (true) {
            float result = 0f;
            System.out.println("Введите число 1: ");
            chekInt(scanner);
            int a = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите число 2: ");
            chekInt(scanner);
            int b = scanner.nextInt();
            System.out.println("Введите + для сложения, - для вычитания, * для умножения, / для деления:");
            String symbol = scanner.next();
            switch (symbol) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b != 0) {
                        result = (float) a / b;
                    } else {
                        System.out.println("Ошибка! Деление на ноль");
                    }
                    break;
                default:
                    System.out.println("Такой опции не существует");
            }
            System.out.println("Результат: " + result);
            result = 0;
            System.out.println("Введите Да , если хотите завершить");
            String exit = scanner.next();
            if (exit.equals("Да")) //завершение работы
                System.exit(0);
        }
    }

    public static void chekInt(Scanner scanner) { // Метод проверки ввода числа
        while (!scanner.hasNextInt()) {
            System.out.println("Введите число!");
            scanner.nextLine();
        }
    }
}
