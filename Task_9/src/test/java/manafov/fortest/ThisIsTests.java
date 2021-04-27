package manafov.fortest;

import manafov.DoAfterAll;
import manafov.DoBeforeAll;
import manafov.ThisIsTest;

public class ThisIsTests {
    @ThisIsTest(order = 2)
    public void test2() {
    }

    @DoBeforeAll
    public void setUp() {
    }

    @ThisIsTest()
    public void test1() {
    }

    @DoAfterAll
    public void tearDown() {
    }

    @ThisIsTest(order = 3)
    public void test3() {
    }
}
