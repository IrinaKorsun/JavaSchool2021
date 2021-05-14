package ryzhenko;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestWithoutThisIsTest {

    @Test
    public void TestOurTests() {
        assertThrows(Exception.class, () -> TestRunner.start(TestWithoutThisIsTest.class));
    }

    @DoBeforeAll
    static void BeforeAll() {
    }

    @DoAfterAll
    static void AfterAll() {
    }

}
