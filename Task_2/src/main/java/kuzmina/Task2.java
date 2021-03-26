package kuzmina;

public class Task2 {
    public static void main(String[] args) {
        String s = "VvvveeeeeeeeeerrrrrryyyyyyyyyyyyyyyyyyyyyyyyyyyyLooooooooooooooooooooooo" +
                "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
                "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
                "oooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
                "ooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
                "ooooooooooooooooooooooooooooonnnnngggSssttrrriiinnnnnggggggg";


        long startTime = System.nanoTime();
        calculateHash(s);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("That took " + (estimatedTime) + " nanosecconds");


        startTime = System.nanoTime();
        calculateHash(s);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("That took " + (estimatedTime) + " nanosecconds");


        startTime = System.nanoTime();
        calculateHash(s);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("That took " + (estimatedTime) + " nanosecconds");


        startTime = System.nanoTime();
        calculateHash(s);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("That took " + (estimatedTime) + " nanosecconds");


    }

    private static int calculateHash(String s) {
        return s.hashCode();
    }


}
