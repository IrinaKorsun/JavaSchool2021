package kuzminam;

/**
 * Here are 2 files with different class types to test static and regular method. Class prints text message.
 */
public class Printer {
    private String complicated;

    public void hello(String text) {
        System.out.println(text);
        complicated = text;
    }

    public static void hello2(String text) {
        System.out.println(text);
    }
}
