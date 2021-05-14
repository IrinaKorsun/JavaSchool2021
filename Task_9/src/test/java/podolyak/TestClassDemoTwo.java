package podolyak;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import podolyak.demo.DemoClassTwo;

import java.lang.reflect.Method;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestClassDemoTwo {
    private static List<Method> sortTestMethods = new ArrayList<>();
    private static final Class<DemoClassTwo> demoClassTwoClass = DemoClassTwo.class;
    private static Method method;

    @BeforeAll
    static void getSortMethods() {
        try {
            TestClass.start(DemoClassTwo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sortTestMethods = new ArrayList<>(TestClass.getSortedTestMethods());
    }

    @Test
    void testOne() throws Exception {
        method = demoClassTwoClass.getMethod("testOne");
        assertEquals(method, sortTestMethods.get(0));
    }

    @Test
    void testTwo() throws Exception {
        method = demoClassTwoClass.getMethod("testTwo");
        assertEquals(method, sortTestMethods.get(1));
    }

    @Test
    void testTree() throws Exception {
        method = demoClassTwoClass.getMethod("testTree");
        assertEquals(method, sortTestMethods.get(2));
    }
}