package lesnoy;

public class Task3 {
    public static void main(String[] args) {
        double firstNumber;
        double secondNumber;
        String operationSymbol;

        if (args.length == 3) {
            firstNumber = Double.parseDouble(args[0]);
            operationSymbol = args[1];
            secondNumber = Double.parseDouble(args[2]);

            switch (operationSymbol) {
                case ("+"):
                    System.out.println("Результат = " + (firstNumber + secondNumber));
                    break;
                case ("-"):
                    System.out.println("Результат = " + (firstNumber - secondNumber));
                    break;
                case ("/"):
                    System.out.println("Результат = " + (firstNumber / secondNumber));
                    break;
                case ("*"):
                    System.out.println("Результат = " + (firstNumber * secondNumber));
                    break;
                case ("^"):
                    System.out.println("Результат = " + Math.pow(firstNumber, secondNumber));
                    break;
                default:
                    System.out.println("Некоректный ввод. Повторите!");
                    break;
            }
        } else System.out.println("Неверное количество аргументов");
    }
}

