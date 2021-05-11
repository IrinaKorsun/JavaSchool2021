package galuza;

import galuza.annotation.DoAfterAll;
import galuza.annotation.DoBeforeAll;
import galuza.annotation.ThisIsTest;

public class TestingClass1 {

    @DoBeforeAll
    public String before() {
        return "test method marked as @DoBeforeAll is done";
    }

    @ThisIsTest(priority = 6)
    public String test1() {
        return "test marked as @ThisIsTest is done";
    }

    @ThisIsTest()
    public String test2() {
        return "test marked as @ThisIsTest is done";
    }

    @ThisIsTest()
    public String test3() {
        return "test marked as @ThisIsTest is done";
    }

    @ThisIsTest(priority = 5)
    public String test4() {
        return "test marked as @ThisIsTest is done";
    }

    @ThisIsTest(priority = 4)
    public String test5() {
        return "test marked as @ThisIsTest is done";
    }

    @DoAfterAll
    public String after() {
        return "test method marked as @DoAfterAll is done";
    }
}