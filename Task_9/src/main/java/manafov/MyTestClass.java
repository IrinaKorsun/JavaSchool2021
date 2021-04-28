package manafov;

import java.lang.reflect.Method;
import java.util.*;

public class MyTestClass {
    public static List<String> start(Class<?> testClass) throws Exception {
        Method[] methods = testClass.getDeclaredMethods();
        Method[] beforeAfterAll = checkForBeforeAfterAll(methods);
        Method beforeAll = beforeAfterAll[0];
        Method afterAll = beforeAfterAll[1];
        Object instance = testClass.newInstance();

        Set<Method> methodSet = new TreeSet<>(Comparator.comparing(method ->
                method.getDeclaredAnnotation(ThisIsTest.class).order()));
        for (Method method : methods) {
            if (method.isAnnotationPresent(ThisIsTest.class)) {
                methodSet.add(method);
            }
        }

        List<String> result = new ArrayList<>();
        if (beforeAll != null) {
            beforeAll.invoke(instance);
            result.add(DoBeforeAll.class.getSimpleName());
        }
        if (!methodSet.isEmpty()) {
            for (Method method : methodSet) {
                method.invoke(instance);
                result.add(ThisIsTest.class.getSimpleName() +
                        method.getDeclaredAnnotation(ThisIsTest.class).order());
            }
        }
        if (afterAll != null) {
            afterAll.invoke(instance);
            result.add(DoAfterAll.class.getSimpleName());
        }
        return result;
    }

    /**
     * Проверяет наличие методов с аннотациями @DoBeforeAll и @DoAfterAll.
     *
     * @param methods массив методов.
     * @return массив методов размером 2 с аннотациями @DoBeforeAll и @DoAfterAll.
     * @throws Exception если найдено больше одного метода с аннотациями @DoBeforeAll или @DoAfterAll.
     */
    private static Method[] checkForBeforeAfterAll(Method[] methods) throws Exception {
        Method[] beforeAfterAll = new Method[2];
        for (Method method : methods) {
            if (method.isAnnotationPresent(DoBeforeAll.class)) {
                if (beforeAfterAll[0] != null) {
                    throw new Exception("Метод с аннотацией @DoBeforeAll" +
                            " должен присутствовать в единственном экземпляре");
                }
                beforeAfterAll[0] = method;
            }
            if (method.isAnnotationPresent(DoAfterAll.class)) {
                if (beforeAfterAll[1] != null) {
                    throw new Exception("Метод с аннотацией @DoAfterAll" +
                            " должен присутствовать в единственном экземпляре");
                }
                beforeAfterAll[1] = method;
            }
        }
        return beforeAfterAll;
    }
}
