package galuza;

import galuza.annotation.DoAfterAll;
import galuza.annotation.DoBeforeAll;
import galuza.annotation.ThisIsTest;

public class TestingClass4 {
    @DoBeforeAll
    public String before() {
        return "test method marked as before is done";
    }

    @DoAfterAll
    public String after() {
        return "test method marked as after is done";
    }
}
