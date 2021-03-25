package bakunov;

public class Task3Var1 {
    public static void main(String[] args) {
        if (args.length == 3) {
            switch (args[1]) {
                case ("+"):
                    System.out.println(Double.parseDouble(args[0]) + Double.parseDouble(args[2]));
                    break;
                case ("-"):
                    System.out.println(Double.parseDouble(args[0]) - Double.parseDouble(args[2]));
                    break;
                case ("/"):
                    System.out.println(Double.parseDouble(args[0]) / Double.parseDouble(args[2]));
                    break;
                case ("*"):
                    System.out.println(Double.parseDouble(args[0]) * Double.parseDouble(args[2]));
                    break;
                default:
                    System.out.println("Калькулятор не поддерживает заданную операцию");
                    break;
            }
        }
    }
}
