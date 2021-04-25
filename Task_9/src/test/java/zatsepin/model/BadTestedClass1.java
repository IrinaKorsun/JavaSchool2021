package zatsepin.model;

import zatsepin.annotation.DoAfterAll;
import zatsepin.annotation.ThisIsTest;

/**
 * Invalid test class.
 */
public class BadTestedClass1 {

    @DoAfterAll
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

    @DoAfterAll
    public Result methodAfter() {
        return Result.NINE;
    }
}
