package Sartakova;
import java.util.Scanner;

public class Task3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double a = getDouble();
        double b = getDouble();
        char operation = getOperation();
        double result = calc(a,b,operation);
        System.out.println("Результат операции: "+result);
    }

    public static double getDouble(){
        System.out.println("Введите число:");
        double c;
        if(scanner.hasNextDouble()){
            c = scanner.nextDouble();
        } else {
            System.out.println("Ошибка при вводе числа.");
            scanner.next();
            c = getDouble();
        }
        return c;
    }

    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Ошибка при вводе операции.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static double calc(double a, double b, char operation){
        double result;
        switch (operation){
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(a, b, getOperation());
        }
        return result;
    }
}
