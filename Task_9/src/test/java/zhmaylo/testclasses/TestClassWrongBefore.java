package zhmaylo.testclasses;

import zhmaylo.annotation.DoAfterAll;
import zhmaylo.annotation.DoBeforeAll;
import zhmaylo.annotation.ThisIsTest;

public class TestClassWrongBefore {


    @DoBeforeAll
    public Integer methodBefore() {
        return 0;
    }

    @DoAfterAll
    public Integer methodLast() {
        return 4;
    }

    @ThisIsTest(order = 3)
    public Integer ord3() {
        return 3;
    }

    @ThisIsTest(order = 1)
    public Integer ord1() {
        return 1;
    }

    @DoBeforeAll
    public Integer ord4() {
        return 3;
    }

    @ThisIsTest(order = 2)
    public Integer ord2() {
        return 2;
    }

}
