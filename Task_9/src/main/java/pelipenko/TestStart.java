package pelipenko;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStart {
    public static List<Object> start(Class<?> testClass) throws Exception {
        List<Method> before = getBefore(testClass);

        List<Method> after = getAfter(testClass);

        return getObjects(testClass, before, after);
    }

    private static List<Method> getBefore(Class<?> testClass) {
        var before = Stream.of(testClass.getMethods())
                .filter(m -> m.isAnnotationPresent(DoBeforeAll.class))
                .collect(Collectors.toList());
        if (before.size() > 1) {
            throw new RuntimeException("Больше одной аннотации DoBeforeAll");
        }
        return before;
    }

    private static List<Method> getAfter(Class<?> testClass) {
        var after = Stream.of(testClass.getMethods())
                .filter(m -> m.isAnnotationPresent(DoAfterAll.class))
                .collect(Collectors.toList());
        if (after.size() > 1) {
            throw new RuntimeException("Больше одной аннотации DoAfterAll");
        }
        return after;
    }

    public static List<Object> getObjects(Class<?> testClass, List<Method> before, List<Method> after) throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        var test = Stream.of(testClass.getMethods())
                .filter(m -> m.isAnnotationPresent(ThisIsTest.class))
                .sorted(Comparator.comparingInt(m -> m.getAnnotation(ThisIsTest.class).priority()))
                .collect(Collectors.toList());

        test.addAll(0, before);
        test.addAll(after);
        List<Object> result = new ArrayList<>();
        Object object = testClass.getDeclaredConstructor().newInstance();
        for (var m : test) {
            result.add(m.invoke(object));
        }
        return result;
    }
}
