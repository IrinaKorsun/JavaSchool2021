package pelipenko;


import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        double first = 0, second = 0;
        char operation = '+';
        boolean flag = true;


        while (flag == true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите выражение (вводить в виде \"@число @оператор @число)\":");
            if (scanner.hasNextDouble()) {
                first = scanner.nextDouble();
            } else {
                System.out.println("Введено неверное выражение, повторите попытку");
                continue;
            }
            if (scanner.hasNext("[+-/*/^%]")) {
                operation = scanner.next().charAt(0);
            } else {
                System.out.println("Введено неверное выражение, повторите попытку");
                continue;
            }
            if (scanner.hasNextDouble()) {
                second = scanner.nextDouble();
            } else {
                System.out.println("Введено неверное выражение, повторите попытку");
                continue;
            }

            System.out.println("Ответ: " + calc(first, second, (char) operation));
            System.out.println("Хотите выйти? Для выхода напишите \"yes\" ");
            scanner.nextLine();
            String answer = scanner.nextLine();
            if (answer.equals("Yes") || answer.equals("yes") || answer.equals("y")) {
                flag = false;
            }


        }


    }

    public static double calc(double first, double second, char operation) {
        double result = switch (operation) {
            case '+' -> result = first + second;
            case '-' -> result = first - second;
            case '*' -> result = first * second;
            case '/' -> result = first / second;
            case '^' -> result = Math.pow(first, second);
            case '%' -> result = first % second;
            default -> throw new IllegalStateException("Неизвестная операция: " + operation);
        };
        return result;
    }
}

