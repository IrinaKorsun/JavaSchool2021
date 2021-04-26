package krivko;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Задание 9
 * <br> Класс запускающий учебный unit тест
 */
public class Runner {
    /**
     * Запускаем все методы с аннотациями @ThisIsTest, @DoBeforeAll, @DoAfterAll
     * @param testClass тестируемый класс
     * @return список List<Object> результатов тестируемых методов
     * @throws Exception в случае неудачного запуска тестовых методов (method.invoke)
     */
    public static List<Object> start(Class<?> testClass) throws Exception {
        // Метод До (если есть)
        var before = Stream.of(testClass.getMethods())
                .filter(m -> m.isAnnotationPresent(DoBeforeAll.class))
                .collect(Collectors.toList());
        if (before.size() > 1) {
            throw new RuntimeException("There is more than one @DoBeforeAll annotation");
        }
        // Метод После (если есть)
        var after = Stream.of(testClass.getMethods())
                .filter(m -> m.isAnnotationPresent(DoAfterAll.class))
                .collect(Collectors.toList());
        if (after.size() > 1) {
            throw new RuntimeException("There is more than one @DoAfterAll annotation");
        }
        // Тестовые методы, в выбранном порядке
        var test = Stream.of(testClass.getMethods())
                .filter(m -> m.isAnnotationPresent(ThisIsTest.class))
                .sorted(Comparator.comparingInt(m -> m.getAnnotation(ThisIsTest.class).order()))
                .collect(Collectors.toList());

        // Объединяем методы До + Тестовые + После и запускаем
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