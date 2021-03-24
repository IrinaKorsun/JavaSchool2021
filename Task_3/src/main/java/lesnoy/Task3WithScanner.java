package lesnoy;

import java.util.Scanner;

public class Task3WithScanner {
    public static void main(String[] args) {
        double firstNumber;
        double secondNumber;
        String operationSymbol;
        String str;

        while (true) {
            System.out.println("Введите числа и знак операции (например: 20 + 13): ");
            Scanner sc = new Scanner(System.in);
            str = sc.nextLine();

            if (!str.isEmpty()) {
                String[] input_values = str.split("[+\\-*/^]");
                if (input_values.length != 1) {
                    firstNumber = Double.parseDouble(input_values[0]);
                    operationSymbol = str.substring(input_values[0].length(), str.length() - input_values[1].length());
                    secondNumber = Double.parseDouble(input_values[1]);

                    switch (operationSymbol) {
                        case ("+"):
                            System.out.println("Результат = " + (firstNumber + secondNumber));
                            break;
                        case ("-"):
                            System.out.println("Результат = " + (firstNumber - secondNumber));
                            break;
                        case ("*"):
                            System.out.println("Результат = " + (firstNumber * secondNumber));
                            break;
                        case ("/"):
                            System.out.println("Результат = " + (firstNumber / secondNumber));
                            break;
                        case ("^"):
                            System.out.println("Результат = " + Math.pow(firstNumber, secondNumber));
                            break;
                        default:
                            System.out.println("Некорректный ввод!");
                            break;
                    }
                } else System.out.println("Вы ввели некорректное выражение. Повторите операцию!");
            }
        }
    }
}
