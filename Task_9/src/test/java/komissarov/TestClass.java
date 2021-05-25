package komissarov;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestClass {
    @Test
    void checkTestStart() throws Exception {
        Runner.start(TestHelp5.class);
    }

    @Test
    void TestBeforeAllExeption() {
        TestHelp1 doubleDoBeforeAll = new TestHelp1();
        try {
            Runner.start(doubleDoBeforeAll.getClass());
        } catch (Exception e) {
            assertEquals("Дублирование аннотации DoBeforeAll", e.getMessage());
        }
    }

    @Test
    void TestAfterAllExeption() {
        TestHelp2 doubleDoAfterAll = new TestHelp2();
        try {
            Runner.start(doubleDoAfterAll.getClass());
        } catch (Exception e) {
            assertEquals("Дублирование аннотации DoAfterAll", e.getMessage());
        }
    }

    @Test
    void TestExistBeforeAll() throws Exception {
        TestHelp4 existBeforeAll = new TestHelp4();
        Stream<Method> methodDoBeforeAll = Runner.start(existBeforeAll.getClass())
                .stream().filter(method -> method.getDeclaredAnnotation(DoBeforeAll.class) != null);
        assertEquals(0, methodDoBeforeAll.count());

    }

    @Test
    void TestNotExistThisIsTest() throws Exception {
        TestHelp6 thisIsTestNotExist = new TestHelp6();
        try {
            Runner.start(thisIsTestNotExist.getClass());
            fail();
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Отсутствует аннотация ThisIsTest");
        }

    }

    @Test
    void TestExistThisIsTest() throws Exception {
        TestHelp3 existThisIsTest = new TestHelp3();
        Runner.start(existThisIsTest.getClass());
        Stream<Method> methodThisIsTest = Runner.start(existThisIsTest.getClass())
                .stream().filter(method -> method.getDeclaredAnnotation(ThisIsTest.class) != null);
        assertEquals(1, methodThisIsTest.count());
    }

}
