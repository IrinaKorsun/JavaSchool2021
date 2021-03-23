package bakunov;

import java.util.Scanner;

public class Task3Var2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        String[] values;
        while (true) {
            System.out.println("Введите выражение (например: 2 + 2): ");
            str = sc.nextLine();
            if (!str.isEmpty()) {
                try {
                    values = str.split("[+\\-*/]");
                    if (values.length == 2) {
                        if (str.contains("+")) {
                            System.out.println(Double.parseDouble(values[0]) + Double.parseDouble(values[1]));
                        } else if (str.contains("-")) {
                            System.out.println(Double.parseDouble(values[0]) - Double.parseDouble(values[1]));
                        } else if (str.contains("/")) {
                            System.out.println(Double.parseDouble(values[0]) / Double.parseDouble(values[1]));
                        } else if (str.contains("*")) {
                            System.out.println(Double.parseDouble(values[0]) * Double.parseDouble(values[1]));
                        } else {
                            System.out.println("Данный тип операции не поддерживается.");
                        }
                    } else {
                        System.out.println("Вы ввели некорректные данные, повторите операцию.");
                    }
                } catch (Exception ex) {
                    System.out.println("Error by exception: " + ex);
                }

            }
        }
    }
}
