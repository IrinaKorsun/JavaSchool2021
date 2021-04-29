package starikov;

import starikov.annotations.ThisIsTest;

/**
 * тестируемый класс без аннотаций @DoBeforeAll и @DoAfterAll
 */
public class TestsClass3 {


    public String doBeforeAll() {
        return "DoBeforeAll";
    }

    public String test1() {
        return "Test1: not annotated";
    }

    @ThisIsTest //приоритет по упомчанию
    public String test2() {
        return "Test2: default priority 2";
    }

    @ThisIsTest(4)
    public String test3() {
        return "Test3: priority 4";
    }

    @ThisIsTest(1)
    public String test4() {
        return "Test4: priority 1";
    }

    public String test5() {
        return "Test5: not annotated";
    }

    @ThisIsTest(3)
    public String test6() {
        return "Test6: priority 3";
    }

    public String doAfterAll() {
        return "DoAfterAll";
    }
}