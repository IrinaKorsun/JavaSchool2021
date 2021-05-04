package emelyanov;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Runner {
    /**
     * Статический метод, запускающий тестовые методы.
     *
     * @param clazz класс-тест
     * @throws Exception Если «класс-тест» содержит более одного метода, помеченного аннотацией DoBeforeAll или DoAfterAll
     */
    public static List<Method> start(Class<?> clazz) throws Exception {
        Method doBefore = null;
        Method doAfter = null;
        int beforeAnnCount = 0;
        int afterAnnCount = 0;
        ArrayList<Method> methodArrayList = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getAnnotation(DoBeforeAll.class) != null) {
                beforeAnnCount++;
                if (beforeAnnCount > 1) {
                    throw new RuntimeException("Найдено больше одной аннотации DoBeforeAll");
                }
                doBefore = method;
            } else if (method.getAnnotation(DoAfterAll.class) != null) {
                afterAnnCount++;
                if (afterAnnCount > 1) {
                    throw new RuntimeException("Найдено больше одной аннотации DoAfterAll");
                }
                doAfter = method;
            } else if (method.getAnnotation(ThisIsTest.class) != null) {
                methodArrayList.add(method);
            }
        }

        methodArrayList.sort(Comparator.comparing(o -> o.getAnnotation(ThisIsTest.class).priority()));
        Object object = clazz.getDeclaredConstructor().newInstance();

        if (doBefore != null) {
            methodArrayList.add(0, doBefore);
        }
        if (doAfter != null) {
            methodArrayList.add(doAfter);
        }

        try {
            for (Method testMethod : methodArrayList) {
                testMethod.invoke(object);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new Exception("Запрещен доступ к классу " + e);
        }
        return methodArrayList;
    }
}