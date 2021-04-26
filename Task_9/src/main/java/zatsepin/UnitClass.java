package zatsepin;

import zatsepin.annotation.DoAfterAll;
import zatsepin.annotation.DoBeforeAll;
import zatsepin.annotation.ThisIsTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class for unit testing.
 */
public class UnitClass {

    /**
     * Runs all methods of the specified class marked with @ThisIsTest, @DoBeforeAll and @DoAfterAll annotations.
     *
     * @param testedClazz class type whose methods run tests
     * @param <T> the type of the class in which we run the methods
     * @return test methods results list
     * @throws Exception if test class contains more than one annotation @DoBeforeAll or @DoAfterAll
     */
    public static <T> List<Object> start(Class<T> testedClazz) throws Exception {
        TreeMap<Integer, List<Method>> testMethodsMap = new TreeMap<>(Comparator.reverseOrder());
        List<Object> methodsResults = new ArrayList<>();
        Method methodBeforeAll = null;
        Method methodAfterAll = null;
        boolean beforeAllFlag = false;
        boolean afterAllFlag = false;
        Method[] allMethods = testedClazz.getDeclaredMethods();

        for (Method method : allMethods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof DoBeforeAll) {
                    if (beforeAllFlag) {
                        throw new Exception("More than one method annotated with @DoBeforeAll");
                    }
                    methodBeforeAll = method;
                    beforeAllFlag = true;
                } else if (annotation instanceof ThisIsTest) {
                    int priority = ((ThisIsTest) annotation).priority();
                    List<Method> samePriorityMethods = testMethodsMap.get(priority);
                    if (samePriorityMethods == null) {
                        samePriorityMethods = new ArrayList<>();
                    }
                    samePriorityMethods.add(method);
                    testMethodsMap.put(priority, samePriorityMethods);
                } else if (annotation instanceof DoAfterAll) {
                    if (afterAllFlag) {
                        throw new Exception("More than one method annotated with @DoAfterAll");
                    }
                    methodAfterAll = method;
                    afterAllFlag = true;
                }
            }
        }
        T testedObj = testedClazz.getDeclaredConstructor().newInstance();
        if (methodBeforeAll != null) {
            methodsResults.add(methodBeforeAll.invoke(testedObj));
        }
        List<Method> testMethods = testMethodsMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        if (!testMethods.isEmpty()) {
            for (Method method : testMethods) {
                methodsResults.add(method.invoke(testedObj));
            }
        }
        if (methodAfterAll != null) {
            methodsResults.add(methodAfterAll.invoke(testedObj));
        }

        return methodsResults;
    }
}
