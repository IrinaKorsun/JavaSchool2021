package prikhozhaya;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassTesting3Test {
    private static Class<ClassTesting3> classTesting = ClassTesting3.class;//Тестируемый класс

    @BeforeAll
    static void beforeAll() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> StartTest.start(classTesting)
        );
        assertTrue(thrown.getMessage().contains("The annotation DoAfterAll must exist in a single copy"));
    }

    @Test
    void afterAllMethod() {
    }

    @Test
    void afterAllMethod2() {
    }
}