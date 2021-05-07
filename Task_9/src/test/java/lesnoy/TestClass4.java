package lesnoy;

import lesnoy.annotation.DoAfterAll;
import lesnoy.annotation.DoBeforeAll;

public class TestClass4 {
    @DoBeforeAll
    public String beforeAllAnnotation() {
        return "@DoBeforeAll";
    }

    @DoAfterAll
    public String afterAllAnnotation() {
        return "@DoAfterAll";
    }
}
