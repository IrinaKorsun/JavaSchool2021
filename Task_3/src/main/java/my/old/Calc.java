package my.old;

public class Calc {
    private double firstVal;
    private double secondVal;

    public void setFirstVal(double firstVal) {
        this.firstVal = firstVal;
    }

    public void setSecondVal(double secondVal) {
        this.secondVal = secondVal;
    }

    public void runOperation(char operation) {
        switch (operation) {
            case '+':
                add(firstVal, secondVal);
                break;
            case '_':
                sub(firstVal, secondVal);
                break;
            case '*':
                mult(firstVal, secondVal);
                break;
            case '/':
                div(firstVal, secondVal);
                break;
        }
    }

    public static void add(double a, double b) {
        System.out.println(a + b);
    }

    public static void sub(double a, double b) {
        System.out.println(a - b);
    }

    public static void mult(double a, double b) {
        System.out.println(a * b);
    }

    public static void div(double a, double b) {
        System.out.println(a / b);
    }
}
