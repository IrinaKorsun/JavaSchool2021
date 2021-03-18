package zatsepin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HelloWorld {
    public static void main(String[] args){
        long startTime = System.nanoTime();
        System.out.println("Hello World ver.1");
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Completed in " + elapsedTime/1000 + " microseconds");
        System.out.println();

        startTime = System.nanoTime();
        List<String> list = new ArrayList<>(Arrays.asList("H", "e", "l", "l", "o", " ", "W", "o", "r", "l", "d", " ", "v", "e", "r.", "2"));
        String result = list.stream().collect(Collectors.joining());
        System.out.println(result);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Completed in " + elapsedTime/1000 + " microseconds");

    }
}
