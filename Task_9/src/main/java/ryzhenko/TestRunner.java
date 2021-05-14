package ryzhenko;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner {

    /**
     * Статический метод, выполнящий тесты с аннотациями @ThisIsTest
     *
     * @param testClass Объект типа Class, который содержит тесты
     * @throws Exception Если @DoBeforeAll и @DoAfterAll, не присутствуют в единственном экземпляре
     */
    public static void start(Class testClass) throws Exception {
        int doBeforeAll = 0;
        int doAfterAll = 0;
        int passed = 0;
        List<Method> tests = new ArrayList();
        Method beforeAll = null;
        Method afterAll = null;
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(DoBeforeAll.class)) {
                doBeforeAll++;
                beforeAll = m;
            }
            if (m.isAnnotationPresent(DoAfterAll.class)) {
                doAfterAll++;
                afterAll = m;
            }
            if (m.isAnnotationPresent(ThisIsTest.class)) {
                tests.add(m);
            }
        }
        if (doBeforeAll > 1) {
            throw new Exception("One annotation @DoBeforeAll is expected");
        }
        if (doAfterAll > 1) {
            throw new Exception("One annotation @DoAfterAll is expected");
        }
        if (tests.size() < 1) {
            throw new Exception("Annotation @ThisIsTest is required");
        }
        if (doBeforeAll != 0) {
            beforeAll.invoke(null);
        }
        tests.sort(Comparator.comparingInt(obj -> obj.getAnnotation(ThisIsTest.class).priority()));
        for (Method m : tests) {
            try {
                m.invoke(null);
                passed++;
            } catch (InvocationTargetException wrappedExc) {
                Throwable exc = wrappedExc.getCause();
                System.out.println(m + " failed: " + exc);
            } catch (IllegalAccessException exc) {
                System.out.println("Invalid test: " + m);
            }
        }
        if (doAfterAll != 0) {
            afterAll.invoke(null);
        }
        System.out.printf("Passed: %d, Failed: %d%n",
                passed, tests.size() - passed);
    }
}