package zatsepin.model;

import zatsepin.annotation.DoAfterAll;
import zatsepin.annotation.DoBeforeAll;
import zatsepin.annotation.ThisIsTest;

/**
 * Correct test class.
 */
public class GoodTestedClass2 {

    @ThisIsTest(priority = 3)
    public Result method3() {
        return Result.THREE;
    }

    @DoAfterAll
    public Result methodAfter() {
        return Result.NINE;
    }

    @ThisIsTest(priority = 1)
    public Result method1() {
        return Result.ONE;
    }

    @DoBeforeAll
    public Result methodBefore() {
        return Result.ZERO;
    }

    @ThisIsTest(priority = 2)
    public Result method2() {
        return Result.TWO;
    }
}