package shakina;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestClassWith2MethodsDoAfterAll {

    @Test
    public void mainTestMethod() {
        Exception exception = assertThrows(RuntimeException.class, () -> AnnotationAnalyzer.start(TestClassWith2MethodsDoAfterAll.class));
        assertEquals("Методов с аннотацией @DoAfterAll больше одного", exception.getMessage());
    }

    @DoBeforeAll
    public int methodBefore() {
        return Integer.MIN_VALUE;
    }

    @ThisIsTest(priority = 1)
    public int methodPriority1() {
        return 1;
    }

    @ThisIsTest(priority = 2)
    public int methodPriority2() {
        return 2;
    }

    @ThisIsTest(priority = 1)
    public int methodPriority1Repeat() {
        return 1;
    }

    @ThisIsTest(priority = 3)
    public int methodPriority3() {
        return 3;
    }

    @DoAfterAll
    public int methodAfter() {
        return Integer.MAX_VALUE;
    }

    @DoAfterAll
    public int methodAfter2() {
        return Integer.MAX_VALUE;
    }
}
