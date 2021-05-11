package sartakova;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Класс-обработчик для аннотаций @DoBeforeAll, @DoAfterAll и @ThisIsTest
 */

public class MyAnnotationTest {
    /**
     * Поиск в указанном классе всех методы с аннотациями @DoBeforeAll, @DoAfterAll и @ThisIsTest,
     * выполняется проверка, что аннотациями @DoBeforeAll и @DoAfterAll помечены не больше одного метода,
     * выполняется сортиовка методов с аннотацией @ThisIsTest в порядке возрастания приоритетов
     * вызов методов в нужном порядке
     * @param testClass - тест-класс методы которого нужно обработать и вызвать
     * @return - List<Integer> - список чисел, при вызове методов
     * @throws Exception - ошибка при вызове аннотированных методов
     */
    public static List<Integer> start(Class<?> testClass) throws Exception {
        List<Integer> listOfResults = new ArrayList<>();
        Method beforeMethod = null;
        Method afterMethod = null;
        List<Method> testMethods = new ArrayList<>();

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DoBeforeAll.class)) {
                if (beforeMethod == null) {
                    beforeMethod = method;
                } else {
                    throw new RuntimeException("Ошибка! Методов с аннотацией @DoBeforeAll более одного");
                }
            }
            if (method.isAnnotationPresent(DoAfterAll.class)) {
                if (afterMethod == null) {
                    afterMethod = method;
                } else {
                    throw new RuntimeException("Ошибка! Методов с аннотацией @DoAfterAll более одного");
                }
            }
            if (method.isAnnotationPresent(ThisIsTest.class)) {
                testMethods.add(method);
            }
        }

        testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(ThisIsTest.class).priority()));

        Object instance = testClass.getDeclaredConstructor().newInstance();
        if (beforeMethod != null)
            listOfResults.add((Integer) beforeMethod.invoke(instance));
        for (Method m : testMethods) {
            listOfResults.add((Integer) m.invoke(instance));
        }
        if (afterMethod != null)
            listOfResults.add((Integer) afterMethod.invoke(instance));

        return listOfResults;
    }
}
