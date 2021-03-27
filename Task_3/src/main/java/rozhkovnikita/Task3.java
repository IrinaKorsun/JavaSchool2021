package rozhkovnikita;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        double firstNumber = 0;
        char operator;
        double secondNumber = 0;
        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                firstNumber = in.nextDouble();
                operator = in.next().charAt(0);
                secondNumber = in.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введите число");
                continue;
            }
            double answer = 0;
            switch (operator) {
                case ('+'):
                    answer = firstNumber + secondNumber;
                    break;
                case ('-'):
                    answer = firstNumber - secondNumber;
                    break;
                case ('*'):
                    answer = firstNumber * secondNumber;
                    break;
                case ('/'):
                    answer = firstNumber / secondNumber;
                    break;
                default:
                    System.out.println("Ошибка! Выберите правильную операцию");
            }
            System.out.println(answer);
        }
    }
}