package mozzherin;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Calc calc = new Calc();
        Scanner input = new Scanner(System.in);

        while (true) {
            String[] expression = input.nextLine().split(" ");

            calc.setFirstVal(Double.parseDouble(expression[0]));
            calc.setSecondVal(Double.parseDouble(expression[2]));
            calc.runOperation(expression[1].charAt(0));
        }
    }
}
