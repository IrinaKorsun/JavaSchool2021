package khoroshev.anotatedClasses;


import khoroshev.anotations.DoAfterAll;
import khoroshev.anotations.DoBeforeAll;
import khoroshev.anotations.ThisIsTest;

public class SuccessClass {

    @DoBeforeAll
    public int doBeforeAllMethod() {
        return 1;
    }

    @DoAfterAll
    public int doAfterAllMethod() {
        return 5;
    }

    @ThisIsTest
    public int firstMethod() {
        return 2;
    }

    @ThisIsTest(priority = 3)
    public int secondMethod() {
        return 3;
    }

    @ThisIsTest(priority = 4)
    public int thirdMethod() {
        return 4;
    }

}