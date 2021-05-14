package ryzhenko;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestDefault {

    @Test
    public void TestOurTests() throws Exception {
        TestRunner.start(TestDefault.class);
    }

    @DoBeforeAll
    static void BeforeAll() {
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
