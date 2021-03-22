package lesnoy;

public class Task3 {
    public static void main(String[] args) {

        double first_number = Double.parseDouble(args[0]);
        double second_number = Double.parseDouble(args[2]);
        String operation_symbol = args[1];

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