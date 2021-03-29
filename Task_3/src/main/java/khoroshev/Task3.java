package khoroshev;

public class Task3 {
    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                switch (args[1]) {
                    case "+":
                        System.out.printf("%s", sum(Float.parseFloat(args[0]), Float.parseFloat(args[2])));
                        break;
                    case "-":
                        System.out.printf("%s", diff(Float.parseFloat(args[0]), Float.parseFloat(args[2])));
                        break;
                    case "*":
                        System.out.printf("%s", multiply(Float.parseFloat(args[0]), Float.parseFloat(args[2])));
                        break;
                    case "/":
                        System.out.printf("%s", division(Float.parseFloat(args[0]), Float.parseFloat(args[2])));
                        break;
                    case "%":
                        System.out.printf("%s", mod(Float.parseFloat(args[0]), Float.parseFloat(args[2])));
                        break;
                }
            } else {
                System.out.println("Введите данные!");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Переданы неверные параметры.");
        }
    }

    public static String sum(float a, float b) {
        return String.valueOf(a + b);
    }

    public static String diff(float a, float b) {
        return String.valueOf(a - b);
    }

    public static String multiply(float a, float b) {
        return String.valueOf(a * b);
    }

    public static String division(float a, float b) {
        if (b == 0) {
            return "Делить на ноль нельзя!";
        }
        return String.valueOf(a / b);
    }

    public static String mod(float a, float b) {
        if (b == 0) {
            return "Второй операнд должен быть отличный от нуля!";
        }
        return String.valueOf(a % b);
    }
}
