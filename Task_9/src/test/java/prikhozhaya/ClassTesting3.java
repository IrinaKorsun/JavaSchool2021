package prikhozhaya;

import prikhozhaya.annotations.DoAfterAll;
import prikhozhaya.annotations.DoBeforeAll;
import prikhozhaya.annotations.ThisIsTest;

/**
 * Класс для проверки процесса запуска тестов (с ошибкой для аннотации @DoAfterAll).
 */
public class ClassTesting3 {

    @DoAfterAll
    public String afterAllMethod() {
        return "afterAllMethod";
    }

    @DoAfterAll
    public String afterAllMethod2() {
        return "afterAllMethod2";
    }
}
