package prikhozhaya;

import prikhozhaya.annotations.ThisIsTest;

/**
 * Класс для проверки процесса запуска тестов (без учета приоритета).
 */
public class ClassTesting2 {
    @ThisIsTest
    public String testMethod1() {
        return "testMethod1";
    }

    @ThisIsTest
    public String testMethod2(){
        return "testMethod2";
    }

    @ThisIsTest
    public String testMethod3() {
        return "testMethod3";
    }
}
