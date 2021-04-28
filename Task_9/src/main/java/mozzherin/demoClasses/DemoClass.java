package mozzherin.demoClasses;

import mozzherin.annotation.DoAfterAll;
import mozzherin.annotation.DoBeforeAll;
import mozzherin.annotation.ThisIsTest;

public class DemoClass {
    private static final int EXECUTION_PRIORITY_0 = 0;
    private static final int EXECUTION_PRIORITY_1 = 1;
    private static final int EXECUTION_PRIORITY_2 = 2;
    private static final int EXECUTION_PRIORITY_3 = 3;
    private static final int EXECUTION_PRIORITY_4 = 4;
    private static final int EXECUTION_PRIORITY_5 = 5;


    @DoBeforeAll
    public int methodBefore() {
        return EXECUTION_PRIORITY_0;
    }

    @ThisIsTest(priority = 4)
    public int method1() {
        return EXECUTION_PRIORITY_4;
    }

    @ThisIsTest(priority = 1)
    public int method2() {
        return EXECUTION_PRIORITY_1;
    }

    @ThisIsTest(priority = 3)
    public int method3() {
        return EXECUTION_PRIORITY_3;
    }

    @ThisIsTest(priority = 2)
    public int method4() {
        return EXECUTION_PRIORITY_2;
    }

    @DoAfterAll
    public int methodAfter() {
        return EXECUTION_PRIORITY_5;
    }
}
