package prikhozhaya;

import prikhozhaya.annotations.DoAfterAll;
import prikhozhaya.annotations.DoBeforeAll;
import prikhozhaya.annotations.ThisIsTest;

/**
 * Класс для проверки процесса запуска тестов (с ошибкой для аннотации @DoBeforeAll).
 */
public class ClassTesting4 {

    @DoBeforeAll
    public String beforeAllMethod() {
        return "beforeAllMethod";
    }

    @DoBeforeAll
    public String beforeAllMethod2() {
        return "beforeAllMethod2";
    }
}
