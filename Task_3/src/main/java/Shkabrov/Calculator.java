package Shkabrov;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        boolean endAppWork = false;
        double inputFirstNumber = 0;
        double inputSecondNumber = 0;
        double calculationResult = 0;
        boolean exitOperationInput = true;
        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Program can perform the following operations: addition, " +
                "subtraction, multiplication, division, calculating the remainder of the division, " +
                "raising a number to a power");
        while (!endAppWork) {
            System.out.println("Enter first number:");
            if (checkCorrectnessNumberInput(consoleInput)) {
                inputFirstNumber = consoleInput.nextDouble();
            } else {
                endAppWork = true; // Корректное число не было введено, выход из приложения
                continue;
            }
            System.out.println("Enter second number:");
            if (checkCorrectnessNumberInput(consoleInput)) {
                inputSecondNumber = consoleInput.nextDouble();
            } else {
                endAppWork = true;
                continue;
            }
            do {
                exitOperationInput = true; // Обновляем флаг для повторной проверки корректности ввода оператора
                System.out.println("Enter the required operation: +, -, *, /, remainder, power");
                String tmpOperation = consoleInput.next();
                switch (tmpOperation) {
                    case "+":
                        calculationResult = add(inputFirstNumber, inputSecondNumber);
                        break;
                    case "-":
                        calculationResult = subtract(inputFirstNumber, inputSecondNumber);
                        break;
                    case "*":
                        calculationResult = multiply(inputFirstNumber, inputSecondNumber);
                        break;
                    case "/":
                        if (inputSecondNumber == 0) {
                            System.out.println("Division by zero. Please re-enter the operation.");
                            exitOperationInput = false;
                        } else {
                            calculationResult = divide(inputFirstNumber, inputSecondNumber);
                        }
                        break;
                    case "remainder":
                        calculationResult = calculateRemainder(inputFirstNumber, inputSecondNumber);
                        break;
                    case "power":
                        calculationResult = raiseToPower(inputFirstNumber, inputSecondNumber);
                        break;
                    default:
                        System.out.println("Incorrect operation. Please re-enter the operation.");
                        exitOperationInput = false;
                        if (exitApp(consoleInput)) {
                            endAppWork = true; // Пользователь ввел некорректную операцию и решил закрыть приложение
                        }
                        break;
                }
                if (endAppWork) {
                    break; // Выход из цикла при некорректном вводе оператора с последующим выходом из приложения
                }
                if (exitOperationInput) {
                    System.out.println("Result: " + calculationResult);
                }
            } while (!exitOperationInput);
            if (!endAppWork && exitApp(consoleInput)) {
                endAppWork = true; // Запрос на выход из приложения, после корректного вычисления операции над числами
            }
        }
        consoleInput.close();
    }

    public static boolean checkCorrectnessNumberInput(Scanner consoleInput) {
        while (true) {
            if (consoleInput.hasNextDouble()) {
                return true;
            } else {
                System.out.println("Incorrect input data. Please enter a number.");
                // nextLine() работает некорректно вместе с nextDouble
                consoleInput.next(); // Убираем неверные данные из потока, для считывания новых
                if (exitApp(consoleInput)) {
                    return false; // Пользователь ввел некорректные данные и решил закрыть приложение
                } else {
                    System.out.println("Please enter a number.");
                }
            }
        }
    }

    public static boolean exitApp(Scanner consoleInput) {
        System.out.println("If you want to exit from app, enter \"exit\" or \"continue\" to re-enter data)");
        while (true) {
            String tmpExitCheck = consoleInput.next();
            if (tmpExitCheck.equals("continue")) {
                return false;
            } else if (tmpExitCheck.equals("exit")) {
                return true;
            } else {
                System.out.println("Incorrect input data. " +
                        "If you want to exit from app, enter \"exit\" or \"continue\" to re-enter data)");
            }
        }
    }

    public static double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public static double subtract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public static double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public static double divide(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }

    public static double calculateRemainder(double firstNumber, double secondNumber) {
        return firstNumber % secondNumber;
    }

    public static double raiseToPower(double firstNumber, double secondNumber) {
        return Math.pow(firstNumber, secondNumber);
    }
}
