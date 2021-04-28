package manafov.fortest;

import manafov.ThisIsTest;

public class WithoutBeforeAfterAll {
    @ThisIsTest()
    public void test1() {
    }

    @ThisIsTest(order = 2)
    public void test2() {
    }

    @ThisIsTest(order = 3)
    public void test3() {
    }
}
