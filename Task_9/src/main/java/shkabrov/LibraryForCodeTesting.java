package shkabrov;

import shkabrov.annotations.DoAfterAll;
import shkabrov.annotations.DoBeforeAll;
import shkabrov.annotations.ThisIsTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LibraryForCodeTesting {
    /**
     * Вызывает методы класса, который передается в метод в качестве параметра, с аннотациями: {@code @DoBeforeAll},
     * {@code @ThisIsTest}, {@code @DoAfterAll}.
     *
     * @param testClass класс, методы которого будут вызваны
     * @return список значений, которые возвращают вызванные методы
     * @throws LibraryForCodeTestingException если передается неверное число методов с аннотациями:
     *                                        {@code @DoBeforeAll}, {@code @DoAfterAll}.
     */
    public static List<Integer> Start(Class<?> testClass) throws LibraryForCodeTestingException,
            InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        List<Integer> invokeResults = new ArrayList<>();
        Method doBeforeAll = null;
        Method doAfterAll = null;
        List<Method> thisIsTest = new ArrayList<>();
        for (Method currentMethod : testClass.getDeclaredMethods()) {
            currentMethod.setAccessible(true);
            if (currentMethod.isAnnotationPresent(DoBeforeAll.class)) {
                if (doBeforeAll != null) {
                    throw new LibraryForCodeTestingException(LibraryForCodeTestingErrorCode
                            .WRONG_NUMBER_OF_METHODS_WITH_DO_BEFORE_ALL_ANNOTATION);
                }
                doBeforeAll = currentMethod;
            }
            if (currentMethod.isAnnotationPresent(DoAfterAll.class)) {
                if (doAfterAll != null) {
                    throw new LibraryForCodeTestingException(LibraryForCodeTestingErrorCode
                            .WRONG_NUMBER_OF_METHODS_WITH_DO_AFTER_ALL_ANNOTATION);
                }
                doAfterAll = currentMethod;
            }
            if (currentMethod.isAnnotationPresent(ThisIsTest.class)) {
                thisIsTest.add(currentMethod);
            }
        }
        thisIsTest.sort(Comparator.comparingInt(firstElement -> firstElement.getAnnotation(ThisIsTest.class)
                .executionPriority()));
        Constructor<?> testClassConstructor = testClass.getDeclaredConstructor();
        testClassConstructor.setAccessible(true);
        Object testClassInstance = testClassConstructor.newInstance();
        if (doBeforeAll != null) {
            invokeResults.add((Integer) doBeforeAll.invoke(testClassInstance));
        }
        for (Method currentMethod : thisIsTest) {
            invokeResults.add((Integer) currentMethod.invoke(testClassInstance));
        }
        if (doAfterAll != null) {
            invokeResults.add((Integer) doAfterAll.invoke(testClassInstance));
        }
        return invokeResults;
    }
}
