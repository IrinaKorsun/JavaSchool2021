package kuzmin.lecture.part1.nested;

import java.util.HashMap;
import java.util.Map;

public class Field {
    private int width;
    private int length;

    public Field(Integer width, Integer length) {
        this.width = width;
        this.length = length;

        Point point = new Point();
        point.doSomething();
        System.out.println("privet");
    }

    public class Point {
        private void doSomething() {
            width = width + 1;
        }
    }
}
