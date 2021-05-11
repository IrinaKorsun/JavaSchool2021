package galuza;

import galuza.annotation.DoAfterAll;
import galuza.annotation.DoBeforeAll;
import galuza.annotation.ThisIsTest;
import galuza.exception.DoAfterAllException;
import galuza.exception.DoBeforeAllException;
import galuza.exception.ThisIsTestException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ThisIsTestStarter <T> {

    public static List<Object> start(Class<?> inputClass) throws ThisIsTestException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, DoBeforeAllException, DoAfterAllException {
        List<Method> methodList = fillTheMethodLists(inputClass);
        List<Object> result = new ArrayList<>();
        Object o = inputClass.getDeclaredConstructor().newInstance();
        for (Method method : methodList) {
            result.add(method.invoke(o));
        }
        return result;
    }

    private static List<Method> fillTheMethodLists(Class<?> inputClass) throws ThisIsTestException, DoBeforeAllException, DoAfterAllException {
        Method[] methods = inputClass.getDeclaredMethods();
        List<Method> beforeAllMethods = new ArrayList<>();
        List<Method> afterAllMethods = new ArrayList<>();
        List<Method> thisIsTestMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(DoBeforeAll.class)) {
                beforeAllMethods.add(method);
                if (beforeAllMethods.size() > 1) {
                    throw new DoBeforeAllException("Method, marked with annotation DoBeforeAll, must be singular");
                }
            }
            if (method.isAnnotationPresent(DoAfterAll.class)) {
                afterAllMethods.add(method);
                if (afterAllMethods.size() > 1) {
                    throw new DoAfterAllException("Method, marked with annotation DoAfterAll, must be singular");
                }
            }
            if (method.isAnnotationPresent(ThisIsTest.class)) {
                thisIsTestMethods.add(method);
            }
        }
        if (thisIsTestMethods.size() == 0)
            throw new ThisIsTestException("There must be at least one method marked with annotation ThisIsTest");
        else {
            thisIsTestMethods = thisIsTestMethods.stream()
                    .sorted(Comparator.comparingInt(o -> o.getAnnotation(ThisIsTest.class).priority()))
                    .collect(Collectors.toList());
        }
        List<Method> methodList = new ArrayList<>();
        methodList.addAll(beforeAllMethods);
        methodList.addAll(thisIsTestMethods);
        methodList.addAll(afterAllMethods);
        return methodList;
    }
}