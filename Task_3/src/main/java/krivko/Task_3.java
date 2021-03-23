package krivko;

import java.util.Scanner;

/**
 * Задание 3
 * Написать консольный калькулятор, умеющий производить базовые вычисления
 * @author krivko
 * @since 22.03.2021
 * @version 2
 */
public class Task_3 {
    public static void main(String... agr ) {

        double a, b, result;
        String operator;
        Scanner scanner = new Scanner(System.in);

        System.out.println(" -- Калькулятор простых бинарных операций (+ - / * %)");
        System.out.println(" -- Введите данные в формате a * b и нажмите на Enter");
        System.out.println(" -- Внимание! Всё что введете после b учитываться не будет");
        System.out.println(" -- Для выхода наберите символ Q и нажмите Enter");

        while (!scanner.hasNext("[Qq]")) {
            if (scanner.hasNextDouble()) {
                a = scanner.nextDouble();
                if (scanner.hasNext("[+-/*/%]")) {
                    operator = scanner.next();
                    if (scanner.hasNextDouble()) {
                        b = scanner.nextDouble();
                        result = switch (operator) {
                            case "+" -> a + b;
                            case "-" -> a - b;
                            case "*" -> a * b;
                            case "/" -> a / b;
                            case "%" -> a % b;
                            default -> 0;
                        };
                        System.out.printf("%.2f %s %.2f = %.2f\n", a, operator, b, result);
                        scanner.nextLine();
                        continue;
                    }
                }
            }
            System.out.println(" -- У вас явно что то не получилось! Попробуйте ещё раз (или наберите Q и нажмите Enter для выхода)");
            scanner.nextLine();
        }
        System.out.println(" -- Поздравляем! Вам удалось выбраться из калькулятора.");
        scanner.close();
    }
}
