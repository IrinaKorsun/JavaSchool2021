package kuzmin.lecture.nested;

public class Outer {
    public void outer() {
        final int x = 98;
        class Inner {
            public void innerMethod() {
                System.out.println("This is " + x);
            }
        }
        Inner inner = new Inner();
        inner.innerMethod();
    }

    public static void main(String[] args) {
//        Field field = new Field(1, 2);
        Outer outer = new Outer();
        outer.outer();
    }
}
