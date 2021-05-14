package podolyak;

import podolyak.annotation.DoAfterAll;
import podolyak.annotation.DoBeforeAll;
import podolyak.annotation.ThisIsTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestClass {
    public static class Tuple<Method, Integer> {
        Method method;
        Integer index;

        public Method getMethod() {
            return method;
        }

        public Integer getIndex() {
            return index;
        }

        public Tuple(Method method, Integer priority) {
            this.method = method;
            this.index = priority;
        }
    }

    private static Method before = null;
    private static Method after = null;
    private static final List<Tuple<Method, Integer>> listTuple = new ArrayList<>();
    private static final List<Method> sortedTestMethods = new ArrayList<>();

    /**
     * Метод start? ищет все методы класса и запускает их в указанном порядке
     *
     * @param demo тест-класс
     * @throws Exception если повторяются аннотации DoBeforeAll или DoAfterAll
     */
    public static void start(Class demo) throws Exception {
        Method[] methods = demo.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof DoBeforeAll) {
                    if (before != null) {
                        throw new Exception("В классе не может быть больше одной аннотации @DoBeforeAll");
                    } else {
                        before = method;
                    }
                    continue;
                }
                if (annotation instanceof DoAfterAll) {
                    if (after != null) {
                        throw new Exception("В классе не может быть больше одной аннотации @DoAfterAll");
                    } else {
                        after = method;
                    }
                    continue;
                }
                if (annotation instanceof ThisIsTest) {
                    listTuple.add(new Tuple(method, ((ThisIsTest) annotation).priority()));
                }
            }
        }
        Comparator<Tuple<Method, Integer>> comparator = Comparator.comparing(Tuple::getIndex);
        listTuple.sort(comparator);
        Object object = demo.getDeclaredConstructor().newInstance();
        invokeMethods(object, before);
        for (Tuple tuple : listTuple) {
            sortedTestMethods.add((Method) tuple.getMethod());
            invokeMethods(object, (Method) tuple.getMethod());
        }
        invokeMethods(object, after);
    }

    /**
     * Метод вызывает методы класса, если они существуют
     *
     * @param object обьект класса
     * @param method метод этого класса
     */
    public static void invokeMethods(Object object, Method method) {
        if (method != null) {
            try {
                method.invoke(object);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static Method getBefore() {
        return before;
    }

    public static Method getAfter() {
        return after;
    }

    public static List<Method> getSortedTestMethods() {
        return sortedTestMethods;
    }
}
