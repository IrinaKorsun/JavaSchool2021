package zhmaylo.testclasses;


import zhmaylo.annotation.ThisIsTest;

public class TestClassNoBeforeAfter {

    public Object methodBefore() {
        return 0;
    }

    public Object methodLast() {
        return 4;
    }

    @ThisIsTest(order = 3)
    public Object ord3() {
        return 3;
    }

    @ThisIsTest(order = 1)
    public Object ord1() {
        return 1;
    }

    @ThisIsTest(order = 3)
    public Object ord4() {
        return 3;
    }

    @ThisIsTest(order = 2)
    public Object ord2() {
        return 2;
    }

}
