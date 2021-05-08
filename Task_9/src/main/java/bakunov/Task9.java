package bakunov;

import bakunov.annotation.DoAfterAll;
import bakunov.annotation.DoBeforeAll;
import bakunov.annotation.ThisIsTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task9 {

    public static List<Method> start(Class<?> testClass) throws Exception {
        List<Method> sortedTests = new ArrayList<>();
        Method beforeAll = null;
        Method afterAll = null;

        for (Method method : new ArrayList<>(Arrays.asList(testClass.getDeclaredMethods()))) {
            if (method.isAnnotationPresent(DoAfterAll.class)) {
                if (afterAll == null) {
                    afterAll = method;
                } else {
                    throw new Exception("Count annotation @DoAfterAll over more than one!");
                }
            } else if (method.isAnnotationPresent(DoBeforeAll.class)) {
                if (beforeAll == null) {
                    beforeAll = method;
                } else {
                    throw new Exception("Count annotation @DoBeforeAll over more than one!");
                }
            } else if (method.isAnnotationPresent(ThisIsTest.class)) {
                sortedTests.add(method);
            }
        }

        sortedTests.sort(Comparator.comparingInt(o -> o.getAnnotation(ThisIsTest.class).priority()));

        Object testedObject = testClass.getDeclaredConstructor().newInstance();

        if (beforeAll != null) {
            sortedTests.add(0, beforeAll);
        }

        for (Method testMethod : sortedTests) {
            testMethod.invoke(testedObject);
        }

        if (afterAll != null) {
            sortedTests.add(sortedTests.size(), afterAll);
        }

        return sortedTests;
    }
}
