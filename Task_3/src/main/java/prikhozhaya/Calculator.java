package prikhozhaya;

public class Calculator {
    double x1;
    double x2;

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public Calculator() {
    }

    public String add() {
        return x1 + " + " + x2 + " = " + (x1 + x2);
    }

    public String sub() {
        return x1 + " - " + x2 + " = " + (x1 - x2);
    }

    public String mul() {
        return x1 + " * " + x2 + " = " + (x1 * x2);
    }

    public String div() {
        String answer_text;
        if (x2 == 0) {
            answer_text = "На ноль делить нельзя!";
        } else {
            answer_text = x1 + " / " + x2 + " = " + (x1 / x2);
        }
        return answer_text;
    }



}
