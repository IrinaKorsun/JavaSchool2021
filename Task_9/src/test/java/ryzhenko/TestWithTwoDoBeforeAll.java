package ryzhenko;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestWithTwoDoBeforeAll {

    @Test
    public void TestOurTests() {
        assertThrows(Exception.class, () -> TestRunner.start(TestWithTwoDoBeforeAll.class));
    }

    @DoBeforeAll
    static void BeforeAll1() {
    }

    @DoBeforeAll
    static void BeforeAll2() {
    }

    @DoAfterAll
    static void AfterAll() {
    }

    @ThisIsTest(priority = 1)
    static void Test1() {
        System.out.println("Test 1 is running!");
    }

    @ThisIsTest(priority = 2)
    static void Test2() {
        System.out.println("Test 2 is running!");
    }

    @ThisIsTest(priority = 3)
    static void Test3() {
        System.out.println("Test 3 is running!");
    }

}
