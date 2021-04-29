package shkabrov.testClasses;

import shkabrov.annotations.DoAfterAll;
import shkabrov.annotations.DoBeforeAll;
import shkabrov.annotations.ThisIsTest;

public class CorrectClass {
    @ThisIsTest(executionPriority = 3)
    public Integer priority3() {
        return 3;
    }

    @ThisIsTest(executionPriority = 4)
    public Integer priority4() {
        return 4;
    }

    @DoAfterAll
    public Integer priority999() {
        return 999;
    }

    @ThisIsTest()
    public Integer priority1() {
        return 1;
    }

    @ThisIsTest(executionPriority = 2)
    public Integer priority2() {
        return 2;
    }

    @ThisIsTest(executionPriority = 2)
    public Integer priority02() {
        return 2;
    }

    @DoBeforeAll
    public Integer priority0() {
        return 0;
    }
}
