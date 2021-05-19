package lesnoy;

import lesnoy.annotation.DoAfterAll;
import lesnoy.annotation.DoBeforeAll;
import lesnoy.annotation.ThisIsTest;

public class TestClass {
    @DoBeforeAll
    public String beforeAllAnnotation() {
        return "@DoBeforeAll";
    }

    @DoAfterAll
    public String afterAllAnnotation() {
        return "@DoAfterAll";
    }

    @ThisIsTest(priority = 2)
    public String test2() {
        return "priority #2";
    }

    @ThisIsTest(priority = 3)
    public String test1() {
        return "priority #1";
    }

    @ThisIsTest
    public String test3() {
        return "no priority #3";
    }
}
