package galuza;

import galuza.annotation.DoAfterAll;
import galuza.annotation.DoBeforeAll;
import galuza.annotation.ThisIsTest;

public class TestingClass2 {
    @DoBeforeAll
    public String before1() {
        return "test method marked as before is done";
    }

    @DoBeforeAll
    public String before2() {
        return "test method marked as before is done";
    }

    @ThisIsTest()
    public String test2() {
        return "test2 is done";
    }

    @ThisIsTest()
    public String test3() {
        return "test3 is done";
    }

    @ThisIsTest(priority = 5)
    public String test4() {
        return "test4 is done";
    }

    @ThisIsTest(priority = 4)
    public String test5() {
        return "test5 is done";
    }

    @DoAfterAll
    public String after() {
        return "test method marked as after is done";
    }
}