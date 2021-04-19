package kuzmina;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Test8 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Stream.of(map).anyMatch(Map::isEmpty);
        boolean b1 = true;
        System.out.println(b1);
    }
}
