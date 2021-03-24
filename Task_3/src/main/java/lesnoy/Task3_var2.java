package lesnoy;

import java.util.Scanner;

public class Task3_var2 {
    public static void main(String[] args) {

        double first_number;
        double second_number;
        String operation_symbol;
        String str;

        while (true) {
            System.out.println("Введите числа и знак операции (например: 20 + 13): ");

            Scanner sc = new Scanner(System.in);
            str = sc.nextLine();

            if (!str.isEmpty()) {

                String[] input_values = str.split("[+\\-*/^]");
                first_number = Double.parseDouble(input_values[0]);
                operation_symbol = str.substring(input_values[0].length(), str.length() - input_values[1].length());
                second_number = Double.parseDouble(input_values[1]);

                switch (operation_symbol) {
                    case ("+"):
                        System.out.println("Результат = " + (first_number + second_number));
                        break;
                    case ("-"):
                        System.out.println("Результат = " + (first_number - second_number));
                        break;
                    case ("*"):
                        System.out.println("Результат = " + (first_number * second_number));
                        break;
                    case ("/"):
                        System.out.println("Результат = " + (first_number / second_number));
                        break;
                    case ("^"):
                        System.out.println("Результат = " + Math.pow(first_number, second_number));
                        break;
                    default:
                        System.out.println("Некорректный ввод!");
                        break;
                }
            }
        }
    }
}

