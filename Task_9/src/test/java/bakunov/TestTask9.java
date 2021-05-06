package bakunov;

import bakunov.annotation.DoAfterAll;
import bakunov.annotation.DoBeforeAll;
import bakunov.annotation.ThisIsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestTask9 {
    private static final Class<TestPriority> classTesting = TestPriority.class;
    private static List<Method> methodsQueue = new ArrayList<>();

    @BeforeAll
    static void beforeAll() throws Exception {
        methodsQueue = Task9.start(classTesting);
    }

    @Test
    void testMethod2() throws NoSuchMethodException {
        Method method = classTesting.getMethod("testPriority2");
        assertNotNull(method.getAnnotation(ThisIsTest.class));
        assertEquals(method.getAnnotation(ThisIsTest.class).priority(), methodsQueue.indexOf(method));
    }

    @Test
    void testMethod1() throws NoSuchMethodException {
        Method method = classTesting.getMethod("testPriority3");
        assertNotNull(method.getAnnotation(ThisIsTest.class));
        assertEquals(method.getAnnotation(ThisIsTest.class).priority(), methodsQueue.indexOf(method));
    }

    @Test
    void testMethod3() throws NoSuchMethodException {
        Method method = classTesting.getMethod("testNoPriority");
        assertNotNull(method.getAnnotation(ThisIsTest.class));
        assertEquals(method.getAnnotation(ThisIsTest.class).priority(), methodsQueue.indexOf(method));
    }

    @Test
    void afterAllMethod() throws NoSuchMethodException {
        Method method = classTesting.getMethod("afterAllAnnotation");
        assertNotNull(method.getAnnotation(DoAfterAll.class));
        assertEquals((methodsQueue.size() - 1), methodsQueue.indexOf(method));
    }

    @Test
    void beforeAllMethod() throws NoSuchMethodException {
        Method method = classTesting.getMethod("beforeAllAnnotation");
        assertNotNull(method.getAnnotation(DoBeforeAll.class));
        assertEquals(0, methodsQueue.indexOf(method));
    }
}
