package komissarov;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Runner {
    /**
     * Проверки аннотаций тестов.
     *
     * @param clazz тестовый класс
     * @throws Exception происходит при дублировании аннотаций DoBeforeAll или DoAfterAll
     */
    public static List<Method> start(Class<?> clazz) throws Exception {
        Method doBefore = null;
        Method doAfter = null;
        int annotationBeforeCount = 0;
        int annotationAfterCount = 0;
        int annotationThisIsTest = 0;
        ArrayList<Method> listOfMethods = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getAnnotation(DoBeforeAll.class) != null) {
                annotationBeforeCount++;
                isUnique(annotationBeforeCount, DoBeforeAll.class.getSimpleName());
                doBefore = method;
            } else if (method.getAnnotation(DoAfterAll.class) != null) {
                annotationAfterCount++;
                isUnique(annotationAfterCount, DoAfterAll.class.getSimpleName());
                doAfter = method;
            } else if (method.getAnnotation(ThisIsTest.class) != null) {
                annotationThisIsTest++;
                listOfMethods.add(method);
            }
        }

        if (annotationThisIsTest == 0) {
            throw new RuntimeException("Отсутствует аннотация ThisIsTest");
        }

        listOfMethods.sort(Comparator.comparing(o -> o.getAnnotation(ThisIsTest.class).priority()));
        Object object = clazz.getDeclaredConstructor().newInstance();

        if (doBefore != null) {
            listOfMethods.add(0, doBefore);
        }
        if (doAfter != null) {
            listOfMethods.add(doAfter);
        }

        listOfMethods.forEach(method -> {
            try {
                method.invoke(object);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Класс недоступен " + e);
            }
        });
        return listOfMethods;
    }

    private static void isUnique(int annotationCount, String methodName) {
        if (annotationCount > 1) {
            throw new RuntimeException("Дублирование аннотации " + methodName);
        }
    }

}
