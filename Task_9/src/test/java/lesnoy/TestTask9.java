package lesnoy;

import lesnoy.annotation.DoAfterAll;
import lesnoy.annotation.DoBeforeAll;
import lesnoy.annotation.ThisIsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestTask9 {
    private static final Class<TestClass> classTesting = TestClass.class;
    private static final Class<TestClass2> classTesting2 = TestClass2.class;
    private static final Class<TestClass3> classTesting3 = TestClass3.class;
    private static final Class<TestClass4> classTesting4 = TestClass4.class;
    private static List<Method> methodsQueue = new ArrayList<>();
    private static List<Method> methodsQueue2 = new ArrayList<>();
    private static List<Method> methodsQueue3 = new ArrayList<>();
    private static List<Method> methodsQueue4 = new ArrayList<>();

    @BeforeAll
    static void beforeAll() throws Exception {
        methodsQueue = Task9.start(classTesting);
        methodsQueue2 = Task9.start(classTesting2);
    }

    @Test
    void testMethod2() throws NoSuchMethodException {
        Method method = classTesting.getMethod("test2");
        assertNotNull(method.getAnnotation(ThisIsTest.class));
        assertEquals(method.getAnnotation(ThisIsTest.class).priority(), methodsQueue.indexOf(method));
    }

    @Test
    void testMethod1() throws NoSuchMethodException {
        Method method = classTesting.getMethod("test1");
        assertNotNull(method.getAnnotation(ThisIsTest.class));
        assertEquals(method.getAnnotation(ThisIsTest.class).priority(), methodsQueue.indexOf(method));
    }

    @Test
    void testMethod3() throws NoSuchMethodException {
        Method method = classTesting.getMethod("test3");
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

    @Test
    void testManyBefore() {
        Throwable thrown = assertThrows(Exception.class, () -> {
            methodsQueue3 = Task9.start(classTesting3);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void testNoTests() {
        Throwable thrown = assertThrows(Exception.class, () -> {
            methodsQueue4 = Task9.start(classTesting4);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void testMethod2InTestClass2() throws NoSuchMethodException {
        Method method = classTesting2.getMethod("test2");
        assertNotNull(method.getAnnotation(ThisIsTest.class));
        assertEquals(1, methodsQueue2.indexOf(method));
    }

    @Test
    void testMethod1InTestClass2() throws NoSuchMethodException {
        Method method = classTesting2.getMethod("test1");
        assertNotNull(method.getAnnotation(ThisIsTest.class));
        assertEquals(2, methodsQueue2.indexOf(method));
    }

    @Test
    void testMethod3InTestClass2() throws NoSuchMethodException {
        Method method = classTesting2.getMethod("test3");
        assertNotNull(method.getAnnotation(ThisIsTest.class));
        assertEquals(0, methodsQueue2.indexOf(method));
    }

    @Test
    void afterAllMethodInTestClass2() throws NoSuchMethodException {
        Throwable thrown = assertThrows(NoSuchMethodException.class, () -> {
            classTesting2.getMethod("afterAllAnnotation");
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void beforeAllMethodInTestClass2() throws NoSuchMethodException {
        Throwable thrown = assertThrows(NoSuchMethodException.class, () -> {
            classTesting2.getMethod("beforeAllAnnotation");
        });
        assertNotNull(thrown.getMessage());
    }
}
