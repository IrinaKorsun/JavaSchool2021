package prikhozhaya;


import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("Операнд 1 (при вводе вещественного числа используйте запятую): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Некорректно введенные данные!");
                scanner.next();
            }
            calculator.setX1(scanner.nextDouble());

            System.out.println("Операнд 2 (при вводе вещественного числа используйте запятую): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Некорректно введенные данные!");
                scanner.next();
            }
            calculator.setX2(scanner.nextDouble());

            System.out.println("Выберите операцию (сложение '+', вычитание '-', умножение '*', деление '/')");
            String operation = scanner.next();

            switch (operation) {
                case "+":
                    System.out.println(calculator.add());
                    break;
                case "-":
                    System.out.println(calculator.sub());
                    break;
                case "*":
                    System.out.println(calculator.mul());
                    break;
                case "/":
                    System.out.println(calculator.div());
                    break;
                default:
                    System.out.println("Использование данной операции не предусмотрено :(");
                    break;
            }
        }
    }
}
