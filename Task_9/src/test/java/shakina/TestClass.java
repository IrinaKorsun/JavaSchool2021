package shakina;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestClass {

    @Test
    public void mainTestMethod() throws Exception {
        List<Integer> expectedResult = Arrays.asList(Integer.MIN_VALUE, 1, 1, 2, 3, Integer.MAX_VALUE);
        List<Integer> currentResult = AnnotationAnalyzer.start(TestClass.class);
        assertEquals(expectedResult, currentResult);
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
}
