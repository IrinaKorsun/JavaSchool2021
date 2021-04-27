package mozzherin;

import mozzherin.annotation.DoAfterAll;
import mozzherin.annotation.DoBeforeAll;
import mozzherin.annotation.ThisIsTest;
import mozzherin.demoClasses.DemoClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;


public class UnitClass {
    public static void main(String[] args) throws Exception {
        start(DemoClass.class);
    }

    public static <T> HashMap<Integer, Method> start(Class<T> testClass) throws Exception {
        Method[] methods = testClass.getDeclaredMethods();
        HashMap<Integer, Method> testMethodsMap = new HashMap<>();
        Method methodAfterAll = null;
        boolean doBeforeAllFlag = false;
        boolean doAfterAllFlag = false;

        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof DoBeforeAll) {
                    if (doBeforeAllFlag == true) {
                        throw new Exception("Repeated method with @DoBeforeAll");
                    } else {
                        testMethodsMap.put(0, method);
                        doBeforeAllFlag = true;
                    }
                } else if (annotation instanceof ThisIsTest) {
                    testMethodsMap.put(((ThisIsTest) annotation).priority(), method);
                } else if (annotation instanceof DoAfterAll) {
                    if (doAfterAllFlag == true) {
                        throw new Exception("Repeated method with @DoAfterAll");
                    } else {
                        methodAfterAll = method;
                        doAfterAllFlag = true;
                    }
                }
            }
        }
        testMethodsMap.put(testMethodsMap.size(), methodAfterAll);

        return testMethodsMap;
    }
}

