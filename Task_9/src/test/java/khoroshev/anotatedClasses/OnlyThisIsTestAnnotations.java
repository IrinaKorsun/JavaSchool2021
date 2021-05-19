package khoroshev.anotatedClasses;

import khoroshev.anotations.ThisIsTest;

public class OnlyThisIsTestAnnotations {
    @ThisIsTest
    public int firstMethod() {
        return 1;
    }

    @ThisIsTest(priority = 3)
    public int secondMethod() {
        return 2;
    }

    @ThisIsTest(priority = 4)
    public int thirdMethod() {
        return 3;
    }
}
