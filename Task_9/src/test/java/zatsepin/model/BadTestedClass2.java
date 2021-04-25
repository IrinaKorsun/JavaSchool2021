package zatsepin.model;

import zatsepin.annotation.DoBeforeAll;
import zatsepin.annotation.ThisIsTest;

/**
 * Invalid test class.
 */
public class BadTestedClass2 {

    @DoBeforeAll
    public Result methodBefore() {
        return Result.ZERO;
    }

    @ThisIsTest(priority = 1)
    public Result method1() {
        return Result.ONE;
    }

    @ThisIsTest(priority = 2)
    public Result method2() {
        return Result.TWO;
    }

    @ThisIsTest(priority = 3)
    public Result method3() {
        return Result.THREE;
    }

    @DoBeforeAll
    public Result methodAfter() {
        return Result.NINE;
    }
}
