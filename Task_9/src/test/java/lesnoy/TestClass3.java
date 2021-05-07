package lesnoy;

import lesnoy.annotation.DoAfterAll;
import lesnoy.annotation.DoBeforeAll;

public class TestClass3 {
    @DoBeforeAll
    public String beforeAllAnnotation() {
        return "@DoBeforeAll";
    }

    @DoBeforeAll
    public String beforeAllAnnotation2() {
        return "@DoBeforeAll";
    }

    @DoAfterAll
    public String afterAllAnnotation() {
        return "@DoAfterAll";
    }
}
