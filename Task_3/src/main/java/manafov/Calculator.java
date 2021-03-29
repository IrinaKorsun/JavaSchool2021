package manafov;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    private static final Map<String, Operation> operations;

    static {
        Map<String, Operation> operationsMap = new HashMap<>();
        operationsMap.put("+", BigDecimal::add);
        operationsMap.put("-", BigDecimal::subtract);
        operationsMap.put("*", BigDecimal::multiply);
        operationsMap.put("/", (a, b) -> a.divide(b, 32, RoundingMode.HALF_UP).stripTrailingZeros());
        operations = Collections.unmodifiableMap(operationsMap);
    }

    public static void main(String[] args) {
        String[] tokens;
        String expression, operandLeft, operation, operandRight;
        System.out.println("************ Калькулятор 1.0 ************");
        System.out.println("Калькулятор поддерживает операции +, -, *, /");
        System.out.println("Для завершения программы введите -_-");
        System.out.println("Введите выражение в виде: операнд операция операнд");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            expression = scanner.nextLine();
            if (expression.equals("-_-")) {
                System.out.println("Завершаю работу...");
                break;
            }

            tokens = expression.split("(?<=[+\\-*/])|(?=[+\\-*/])");
            if (tokens.length != 3) {
                System.out.println("Введите ровно два операнда с +, -, * или / между ними");
                continue;
            }

            operandLeft = tokens[0].replace(',', '.').trim();
            operation = tokens[1];
            operandRight = tokens[2].replace(',', '.').trim();
            if (!isNumeric(operandLeft) || !isNumeric(operandRight)) {
                System.out.println("Операнды должны быть числами");
                continue;
            }

            try {
                System.out.println(calculate(new BigDecimal(operandLeft), operation, new BigDecimal(operandRight)));
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static BigDecimal calculate(BigDecimal operandLeft, String operation, BigDecimal operandRight) {
        return operations.get(operation).calculate(operandLeft, operandRight);
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            BigDecimal d = new BigDecimal(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
