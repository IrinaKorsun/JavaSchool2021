package prikhozhaya;

import prikhozhaya.annotations.DoAfterAll;
import prikhozhaya.annotations.DoBeforeAll;
import prikhozhaya.annotations.ThisIsTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Класс-обработчик тестов.
 */
public class StartTest {

    /**
     * Статический метод, запускающий тестовые методы.
     * Первым запускается метод с аннотацией @DoBeforeAll (если такой имеется),
     * далее запускает методы с аннотацией @ThisIsTest, а по завершению всех
     * тестов – метод с аннотацией @DoAfterAll (если такой имеется).
     *
     * @сlass сlass - «класс-тест».
     * @return testMethods - список запущенных методов в «классе-тесте».
     * @throws Exception Если «класс-тест» содержит более одного метода, помеченного аннотацией
     *         DoBeforeAll или DoAfterAll.
     */
    public static List<String> start(Class<?> сlass) throws Exception {
        List<Method> methodsClass = new ArrayList<>(Arrays.asList(сlass.getDeclaredMethods()));//Все методы «класса-теста»
        List<Method> testMethods = new ArrayList<>();//Все методы «класса-теста» (отсортированные по приоритету)
        List<String> testNameMethods = new ArrayList<>();//Имена запущенных методов «класса-теста» (отсортированные по приоритету)
        Method beforeAllMethod = null;//Метод, который запуститься первым
        Method afterAllMethod = null;//Метод, который запуститься последним
        boolean beforeAllMethodSet = false;//Проверка на наличие метода с аннотацией DoBeforeAll
        boolean afterAllMethodMethodSet = false;//Проверка на наличие метода с аннотацией DoAfterAll

        for (Method method : methodsClass) {
            if (method.isAnnotationPresent(DoAfterAll.class)) {
                if (!afterAllMethodMethodSet){
                    afterAllMethod = method;
                    afterAllMethodMethodSet = true;
                } else {
                    throw new Exception("The annotation DoAfterAll must exist in a single copy");
                }
            } else if (method.isAnnotationPresent(DoBeforeAll.class)) {
                if (!beforeAllMethodSet){
                    beforeAllMethod = method;
                    beforeAllMethodSet = true;
                } else {
                    throw new Exception("The annotation DoBeforeAll must exist in a single copy");
                }
            } else if (method.isAnnotationPresent(ThisIsTest.class)) {
                testMethods.add(method);
            }
        }

        testMethods.sort(Comparator.comparingInt(o -> o.getAnnotation(ThisIsTest.class).priority()));

        Object testedObject = сlass.getDeclaredConstructor().newInstance();

        if (beforeAllMethod != null) {
            testMethods.add(0, beforeAllMethod);
        }

        if (afterAllMethod != null) {
            testMethods.add(afterAllMethod);
        }

        for (Method testMethod : testMethods) {
            testNameMethods.add((String) testMethod.invoke(testedObject));
        }

        return testNameMethods;
    }
}
