package prikhozhaya;

import prikhozhaya.annotations.DoAfterAll;
import prikhozhaya.annotations.DoBeforeAll;
import prikhozhaya.annotations.ThisIsTest;

/**
 * Класс для проверки процесса запуска тестов (с учетом приоритета).
 */
public class ClassTesting {
    @ThisIsTest(priority = 2)
    public String testMethod2() {
        return "testMethod2";
    }

    @ThisIsTest(priority = 3)
    public String testMethod1(){
        return "testMethod1";
    }

    @ThisIsTest
    public String testMethod3() {
        return "testMethod3";
    }

    @DoAfterAll
    public String afterAllMethod() {
        return "afterAllMethod";
    }

    @DoBeforeAll
    public String beforeAllMethod() {
        return "beforeAllMethod";
    }
}
