package galuza;

import galuza.annotation.DoAfterAll;
import galuza.annotation.DoBeforeAll;
import galuza.annotation.ThisIsTest;

public class TestingClass3 {
    @DoBeforeAll
    public String before() {
        return "test method marked as before is done";
    }

    @ThisIsTest(priority = 6)
    public String test1() {
        return "test1 is done";
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

    @DoAfterAll
    public String after1() {
        return "test5 is done";
    }

    @DoAfterAll
    public String after2() {
        return "test method marked as after is done";
    }
}