package lesnoy;

import lesnoy.annotation.DoAfterAll;
import lesnoy.annotation.DoBeforeAll;
import lesnoy.annotation.ThisIsTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task9 {
    public static List<Method> start(Class<?> clazz) throws Exception {
        List<Method> tests = new ArrayList<>();
        Method beforeAll = null;
        Method afterAll = null;
        for (Method method : new ArrayList<>(Arrays.asList(clazz.getDeclaredMethods()))) {
            if (method.isAnnotationPresent(DoAfterAll.class)) {
                if (afterAll == null) {
                    afterAll = method;
                } else {
                    throw new Exception("Many annotations DoAfterAll");
                }
            } else if (method.isAnnotationPresent(DoBeforeAll.class)) {
                if (beforeAll == null) {
                    beforeAll = method;
                } else {
                    throw new Exception("Many annotations DoBeforeAll");
                }
            } else if (method.isAnnotationPresent(ThisIsTest.class)) {
                tests.add(method);
            }
        }
        if (tests.size() == 0){
            throw new Exception("Not tests!!");
        }
        tests.sort(Comparator.comparingInt(o -> o.getAnnotation(ThisIsTest.class).priority()));
        Object toTestObj = clazz.getDeclaredConstructor().newInstance();
        if (beforeAll != null) {
            tests.add(0, beforeAll);
        }
        for (Method testMethod : tests) {
            testMethod.invoke(toTestObj);
        }
        if (afterAll != null) {
            tests.add(tests.size(), afterAll);
        }
        return tests;
    }
}
