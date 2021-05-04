package emelyanov;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RunnerTest {

    @Test
    void checkTestStart() {
        try {
            Runner.start(ClassForTest.class);
        } catch (Exception e) {
            assertThrows(Exception.class, (Executable) e);
        }
    }

    @Test
    void checkDuplicateDoBeforeAll() {
        ClassForTestDuplicateDoBeforeAll duplicateDoBeforeAll = new ClassForTestDuplicateDoBeforeAll();
        try {
            Runner.start(duplicateDoBeforeAll.getClass());
        } catch (Exception e) {
            assertEquals("Найдено больше одной аннотации DoBeforeAll", e.getMessage());
        }
    }

    @Test
    void checkNoExistDoBeforeAll() throws Exception {
        ClassForTestsNoDoBeforeAll testsNoExistDoBeforeAll = new ClassForTestsNoDoBeforeAll();
        Stream<Method> methodThisIsTest = Runner.start(testsNoExistDoBeforeAll.getClass())
                .stream().filter(method -> method.getDeclaredAnnotation(DoBeforeAll.class) != null);
        assertEquals(0, methodThisIsTest.count());

    }

    @Test
    void checkExistThisIsTest() throws Exception {
        ClassForTestsExistThisIsTest existThisIsTest = new ClassForTestsExistThisIsTest();
        Runner.start(existThisIsTest.getClass());
        Stream<Method> methodThisIsTest = Runner.start(existThisIsTest.getClass())
                .stream().filter(method -> method.getDeclaredAnnotation(ThisIsTest.class) != null);
        assertEquals(1, methodThisIsTest.count());
    }

    @Test
    void checkDuplicateDoAfterAll() {
        ClassForTestDuplicateDoAfterAll duplicateDoAfterAll = new ClassForTestDuplicateDoAfterAll();
        try {
            Runner.start(duplicateDoAfterAll.getClass());
        } catch (Exception e) {
            assertEquals("Найдено больше одной аннотации DoAfterAll", e.getMessage());
        }
    }
}
