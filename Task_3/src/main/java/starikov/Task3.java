package starikov;

import java.util.Scanner;

public class Task3 {

    private static String[] operators = {"+", "-", "*", "/", "%", "x"};

    private static boolean isOperator(String str) {
        for (String elem : operators
        ) {
            if (elem.equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private static String getOperator() {
        Scanner sc = new Scanner(System.in);
        do {
            String operator = sc.next().trim();

            if (operator.equalsIgnoreCase("exit")) {
                throw new RuntimeException("Get exit code!");
            }

            if (isOperator(operator)) {
                return operator;
            }

            System.out.println("Wrong operator. Repeat enter");
        } while (true);
    }

    private static int getNumber() {
        Scanner sc = new Scanner(System.in);
        do {
            String number = sc.next().trim();

            if (number.equalsIgnoreCase("exit")) {
                throw new RuntimeException("Get exit code!");
            }

            if (isNumber(number)) {
                return Integer.parseInt(number);
            }

            System.out.println("Non-digital value. Repeat enter");
        } while (true);
    }

    public static void main(String[] args) {
        //ситуация выхода значений за пределы диапазона int не обрабатывается
        int number1 = 0;
        int number2 = 0;
        String operator = "";
        boolean isCmdValueRight = true;

        System.out.println("To exit program enter \"exit\"");
        //проверка параметров командной строки
        if (args.length < 3) {
            isCmdValueRight = false;
        } else {
            if (!(isNumber(args[0]) && isNumber(args[2]) && isOperator(args[1]))) {
                isCmdValueRight = false;
            }
        }

        if (args.length > 0 && !isCmdValueRight) {
            System.out.println("invalid command line parameters");
        }

        try {
            while (true) {
                //если параметры командной строки не верны, то запрашиваем у пользователя
                if (isCmdValueRight) {
                    number1 = Integer.parseInt(args[0]);
                    operator = args[1];
                    number2 = Integer.parseInt(args[2]);
                    isCmdValueRight = false;
                } else {
                    System.out.print("Enter the first number: ");
                    number1 = getNumber();
                    System.out.print("Enter the operator ( + - * / % ): ");
                    operator = getOperator();
                    System.out.print("Enter the second number: ");
                    number2 = getNumber();
                }

                switch (operator) {
                    case ("+"):
                        System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
                        break;
                    case ("-"):
                        System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
                        break;
                    //добавлен "x" вместо "*" как оператор командной строки
                    //так как знак "*" как аргумент командной строки воспринимается как спецсимвол
                    case ("x"):
                    case ("*"):
                        System.out.println(number1 + " * " + number2 + " = " + (number1 * number2));
                        break;
                    case ("/"):
                        System.out.println(number1 + " / " + number2 + " = " + (double) number1 / number2);
                        break;
                    default:
                        System.out.println(number1 + " % " + number2 + " = " + (number1 % number2));
                        break;
                }
            }
        } catch (RuntimeException ex) {
            System.out.println("The program is over");
        }
    }
}