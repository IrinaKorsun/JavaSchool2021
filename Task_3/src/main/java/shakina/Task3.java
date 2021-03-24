package shakina;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    private static double firstNum;
    private static double secondNum;
    private static String operation;

    public static void main(String[] args) {
        while (true) {
            try {
                read();
            } catch (InputMismatchException exception) {
                System.out.println("Неверный формат ввода");
                continue;
            }
            System.out.println(calculate());
        }
    }

    private static void read() {
        System.out.println("Введите выражение для вычисления (через пробел): ");
        Scanner scanner = new Scanner(System.in);
        firstNum = scanner.nextDouble();
        operation = scanner.next();
        secondNum = scanner.nextDouble();
    }


    private static String calculate() {
        double result;
        switch (operation) {
            case ("+"):
                result = firstNum + secondNum;
                break;
            case ("-"):
                result = firstNum - secondNum;
                break;
            case ("*"):
                result = firstNum * secondNum;
                break;
            case ("/"):
                if (secondNum == 0) {
                    return "Делить на 0 нельзя";
                } else {
                    result = firstNum / secondNum;
                    break;
                }
            default:
                return "Вы ввели неверную операцию";
        }
        return firstNum + " " + operation + " " + secondNum + " = " + result;
    }
}
