package prikhozhaya;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassTesting4Test {
    private static Class<ClassTesting4> classTesting = ClassTesting4.class;//Тестируемый класс

    @BeforeAll
    static void beforeAll() {
        Exception thrown = assertThrows(
            Exception.class,
            () -> StartTest.start(classTesting)
        );
        assertTrue(thrown.getMessage().contains("The annotation DoBeforeAll must exist in a single copy"));
    }

    @Test
    void beforeAllMethod() {
    }

    @Test
    void beforeAllMethod2() {
    }
}