package strashny;


import java.util.Scanner;

class Calculator {

    /**
     * Флаг завершения программы
     */
    boolean flag = true;
    Scanner scanner = new Scanner(System.in);

    /**
     * Метод выводит на экран приветствие пользователю
     */
    private void hello() {
        System.out.println();
        System.out.println("**************************************************************************************************");
        System.out.println("| Добро пожаловать в КАЛЬКУЛЯТОР. Для вычисления ввведите два числа и математическую операцию    |");
        System.out.println("| Для выхода из программы наберрите 'exit'                                                       |");
        System.out.println("**************************************************************************************************");
        System.out.println();
    }

    /**
     * Метод выводит на экран сообщение о завершении программы
     */
    private void bay() {
        System.out.println("*****************************************************************************");
        System.out.println("| Спасибо за использование нашего калькулятора дай бог Вам здоровья!!!!!    |");
        System.out.println("*****************************************************************************");
    }

    /**
     * Метод выводит на экран сообщение о продолжении вычисления
     * и считывает с клавиатуры введенные данные
     */
    private void onceMore() {
        if (flag) {
            System.out.println();
            System.out.println("******************************************");
            System.out.println("| Желаете еще раз выполнить вычисления?  |");
            System.out.println("|  Yes / No                              |");
            System.out.println("******************************************");

            switch (this.scanner.next()) {
                case "Y":
                    break;
                case "y":
                    break;
                case "N":
                    flag = false;
                    break;
                case "n":
                    flag = false;
                    break;
                default:
                    System.out.println("Чот не понятно давай еще считать ");
                    break;
            }
        }
    }

    /**
     * Метод считывает математическую операцию с клавиатуры и делает вычисления между двумя
     * цифрами переданными в метод
     * @param a первый аргумент для вычисления
     * @param b второй аргумент для вычисления
     */
    private void operationOutRezult(Double a, Double b) {
        boolean flag = true;
        if (this.flag) {
            while (flag) {
                System.out.println("Выберите операцию (сложение '+', вычитание '-', умножение '*', деление '/')");
                switch (this.scanner.next()) {
                    case "+":
                        System.out.println("Ответ: " + (a + b));
                        flag = false;
                        break;
                    case "-":
                        System.out.println("Ответ: " + (a - b));
                        flag = false;
                        break;
                    case "*":
                        System.out.println("Ответ: " + (a * b));
                        flag = false;
                        break;
                    case "/":
                        System.out.println("Ответ: " + (a / b));
                        flag = false;
                        break;
                    case "exit":
                        flag = false;
                        this.flag = false;
                        break;
                    default:
                        System.out.println("Чот не та математичекая операция : ");
                        break;
                }
            }
        }
    }

    /**
     * Метод считиывает данные с клавиатуры и возращает их в виде Double
     * @param textAndNumber сообщение выводящиеся в консоль перед считыванием данных с клавиатуры
     * @return возвращаемый параметр в формате Double
     */
    private Double enterVariable(String textAndNumber) {
        if (flag) {
            System.out.println(textAndNumber);
            while (!this.scanner.hasNextDouble()) {
                if (this.scanner.hasNext("exit")) {
                    flag = false;
                    break;
                } else
                    System.out.println("Это не число. " + textAndNumber);
                this.scanner.next();
            }
        }
        return flag ? this.scanner.nextDouble() : null;
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator(); // создаем объект Calculator

        do {
            calculator.hello(); // здороваемся
            Double numberOne = calculator.enterVariable("Введите первое число (дробная часть отделяется запятой): "); // вводим первый аргумент
            Double numberTwo = calculator.enterVariable("Введите второе число (дробная часть отделяется запятой): "); // вводим второй аргумент
            calculator.operationOutRezult(numberOne, numberTwo); // вводим операцию и выводим результат вычисления в консоль
            calculator.onceMore(); // спрашиваем будем еще чего нибудь считать или нет
        } while (calculator.flag);
        calculator.bay();
    }
}