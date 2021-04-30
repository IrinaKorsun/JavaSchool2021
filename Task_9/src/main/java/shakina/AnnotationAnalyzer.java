package shakina;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Класс-обработчик для аннотаций @DoBeforeAll, @DoAfterAll и @ThisIsTest
 */
public class AnnotationAnalyzer {

    /**
     * Метод находит в указанном классе все методы с аннотациями @DoBeforeAll, @DoAfterAll и @ThisIsTest,
     * проверяет, что аннотациями @DoBeforeAll и @DoAfterAll помечены не больше одного метода,
     * сортирует методы с аннотацией @ThisIsTest в порядке возрастания приоритетов
     * и вызывает методы в правильном порядке
     * @param testClass - класс, методы которого нужно обработать и вызвать
     * @return - List<Integer> - лист чисел, сформированный в процессе вызова методов (для тестов)
     * @throws Exception - если в процессе вызова аннотированных методов произошла ошибка
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
                    throw new RuntimeException("Методов с аннотацией @DoBeforeAll больше одного");
                }
            }
            if (method.isAnnotationPresent(DoAfterAll.class)) {
                if (afterMethod == null) {
                    afterMethod = method;
                } else {
                    throw new RuntimeException("Методов с аннотацией @DoAfterAll больше одного");
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
