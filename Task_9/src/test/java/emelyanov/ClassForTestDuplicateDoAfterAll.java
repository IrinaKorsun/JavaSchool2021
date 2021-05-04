package emelyanov;

public class ClassForTestDuplicateDoAfterAll {

    @ThisIsTest(priority = 5)
    public Object testMethod1() {
        return "Test method priority = 5";
    }

    @ThisIsTest(priority = 1)
    public Object testMethod2() {
        return "Test method priority = 1";
    }

    @ThisIsTest(priority = 10)
    public Object testMethod3() {
        return "Test method priority = 10";
    }

    @ThisIsTest
    public Object testMethod5() {
        return "Test method priority = default";
    }

    @DoAfterAll
    public Object afterMethodDuplicate() {
        return "After duplicate method";
    }

    @DoAfterAll
    public Object afterMethod() {
        return "After method";
    }

    @DoBeforeAll
    public Object beforeMethod() {
        return "Before method";
    }
}
