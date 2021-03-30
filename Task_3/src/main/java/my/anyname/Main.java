package my.anyname;

public class Main {
    public static void main(String[] args) {

        Integer a = new Integer(0);
        Integer b = new Integer(0);

        b = a;
        a = 1;
        System.out.println(b);

    }
}
