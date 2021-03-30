package my.old;

public class SecondPart {
    public static void main(String[] args) {
        Integer age = new Integer(5);
        Integer vasyaAge = new Integer(5);

        vasyaAge = age;
        age = 6;
        System.out.println("hello");
    }
}
