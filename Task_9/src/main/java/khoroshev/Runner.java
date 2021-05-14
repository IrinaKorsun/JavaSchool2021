package khoroshev;
import khoroshev.anotations.DoAfterAll;
import khoroshev.anotations.DoBeforeAll;
import khoroshev.anotations.ThisIsTest;
import khoroshev.exception.AnnotateException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public static List<Object> start(Class<?> testClass) throws Exception {
        var doBeforeAllAnnotations = getAnnotatedMethod(testClass, DoBeforeAll.class);
        var doAfterAllAnnotations = getAnnotatedMethod(testClass, DoAfterAll.class);
        var testList = Stream.of(testClass.getMethods())
                .filter(method -> method.isAnnotationPresent(ThisIsTest.class))
                .sorted(Comparator.comparingInt(m -> m.getAnnotation(ThisIsTest.class).priority()))
                .collect(Collectors.toList());
        if (testList.isEmpty()) {
            throw new AnnotateException("Хотя бы один метод должен быть с аннотацией @ThisIsTest");
        }
        testList.addAll(doAfterAllAnnotations);
        testList.addAll(0, doBeforeAllAnnotations);
        List<Object> result = new ArrayList<>();
        Object object = testClass.getDeclaredConstructor().newInstance();
        for (Method method : testList) {
            result.add(method.invoke(object));
        }
        return result;
    }

    private static List<Method> getAnnotatedMethod(Class<?> testClass, Class<? extends Annotation> annotation)
            throws AnnotateException {
        var annotationsList = Stream.of(testClass.getMethods())
                .filter(method -> method.isAnnotationPresent(annotation))
                .collect(Collectors.toList());
        if (annotationsList.size() > 1) {
            throw new AnnotateException("В тестах только один метод может иметь @" + annotation.getSimpleName() + " аннотацию.");
        }
        return annotationsList;
    }
}
