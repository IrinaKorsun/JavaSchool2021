package khoroshev.anotatedClasses;

import khoroshev.anotations.DoAfterAll;
import khoroshev.anotations.DoBeforeAll;

public class WithoutThisIsTestAnnotation {
    @DoBeforeAll
    public int doBeforeAllMethod() {
        return 1;
    }

    @DoAfterAll
    public int doAfterAllMethod() {
        return 5;
    }

}
