package zhmaylo;

import zhmaylo.annotation.DoAfterAll;
import zhmaylo.annotation.DoBeforeAll;
import zhmaylo.annotation.ThisIsTest;

import java.lang.reflect.Method;
import java.util.*;

/**
 * MyTest class, служит для тестирования методов других классов помеченных аннотацией ThisIsTest,
 * аннотация DoBeforeAll выполняется перед всеми тестовыми аннотациями,
 * аннотация DoAfterAll выполняется после всех тестовых аннотаций.
 */
public class MyTest {

    /**
     * При запуске метода с помощью рефлексии собираем все методы переданного класса,
     * ищем среди них аннотированные и выстраиваем их в следющем порядке:
     * DoBeforeAll > ThisIsTest.order(0...N) > DoAfterAll,
     * и вызываем собирая ответы методов в массив.
     *
     * @param wrappedClass тестируемый класс
     * @return список результов работы всех аннотированных методов в правильном порядке.
     * @throws Exception если DoBeforeAll или DoAfterAll больше чем один экземпляр.
     */
    public static <T> List<Object> start(Class<T> wrappedClass) throws Exception {
        Method[] methods = wrappedClass.getMethods();
        List<Method> ListOfMethods = new ArrayList<>();
        List<Object> result = new ArrayList<>();
        T classInst = wrappedClass.getDeclaredConstructor().newInstance();
        Method doBeforeAll = null;
        Method doAfterAll = null;

        for (Method method : methods) {
            if (method.isAnnotationPresent(DoBeforeAll.class)) {
                if (doBeforeAll != null) {
                    throw new Exception("To much DoBeforeAll annotations");
                } else {
                    doBeforeAll = method;
                }
            }
            if (method.isAnnotationPresent(DoAfterAll.class)) {
                if (doAfterAll != null) {
                    throw new Exception("To much DoAfterAll annotations");
                } else {
                    doAfterAll = method;
                }
            }
            if (method.isAnnotationPresent(ThisIsTest.class)) {
                ListOfMethods.add(method);

            }
        }

        ListOfMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(ThisIsTest.class).order()));

        if (doBeforeAll != null) {
            result.add(doBeforeAll.invoke(classInst));
        }
        for (Method method : ListOfMethods) {
            result.add(method.invoke(classInst));
        }
        if (doAfterAll != null) {
            result.add(doAfterAll.invoke(classInst));
        }
        return result;
    }
}
