package berezin;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber;
        double secondNumber;
        double answer;
        String operation;
        boolean flag = true;
        while (flag) {
            System.out.println("Введите элементы и операцию в порядке: число операция число и нажмите Enter");
            System.out.println("Например: 2 + 3");
            firstNumber = Double.parseDouble(scanner.next());
            operation = scanner.next();
            secondNumber = Double.parseDouble(scanner.next());
            if (operation.equals("+")) {
                answer = firstNumber + secondNumber;
                System.out.println(answer);
            } else if (operation.equals("-")) {
                answer = firstNumber - secondNumber;
                System.out.println(answer);
            } else if (operation.equals("*")) {
                answer = firstNumber * secondNumber;
                System.out.println(answer);
            } else if (operation.equals("/") || operation.equals(":")) {
                answer = firstNumber / secondNumber;
                System.out.println(answer);
            } else {
                System.out.println("Некорректно введена операция");
            }
            System.out.println("Для продолжения нажмите 'y', иначе - любой другой символ и Enter");
            flag = scanner.next().equals("y");
        }
        scanner.close();
    }
}
