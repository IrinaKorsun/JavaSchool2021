package kuzminam;

public class HelloWorld {
    public void test() {
        Printer ira = new Printer();
        ira.hello("Hello Ira");
        Printer.hello2("Hello Bro");
    }

    public static void main(String... args){
        HelloWorld a = new HelloWorld();
        a.test();
    }
}
