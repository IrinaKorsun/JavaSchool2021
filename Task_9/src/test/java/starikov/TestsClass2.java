package starikov;

import starikov.annotations.DoAfterAll;
import starikov.annotations.DoBeforeAll;
import starikov.annotations.ThisIsTest;

/**
 * тестируемый класс, содержащий дублируемую аннотацию @DoBeforeAll
 */
public class TestsClass2 {

    @DoBeforeAll
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

    @DoBeforeAll //дублируемая аннотация
    public String test5() {
        return "Test5: not annotated";
    }

    @ThisIsTest(3)
    public String test6() {
        return "Test6: priority 3";
    }

    @DoAfterAll
    public String doAfterAll() {
        return "DoAfterAll";
    }
}