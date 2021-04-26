package starikov;

import starikov.annotations.DoAfterAll;
import starikov.annotations.DoBeforeAll;
import starikov.annotations.ThisIsTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Принимает класс, анализирует анотации его методов и запускает методы переданного класса
 * в определенном порядке, с учетом значений приоритетности, указанной в аннотации методов
 */
public class TestStarter {

    //для проверки корректной работы класса сделаем некоторые допущения:
    // - методы тестового класса будут возвращать строки;
    // - текущий метод будет возвращать список строк с результатами
    // выполнения методов тестового класса;
    public static List<String> start(String className) {

        List<String> resultList = new ArrayList<>();

        try {
            Class<?> cl = Class.forName(className);
            Method[] methods = cl.getDeclaredMethods();

            //инициализируем переменные для ссылок на методы с аннотациями @DoBeforeAll и @DoAfterAll
            Method doBeforeAll = null;
            Method doAfterAll = null;

            //создаем список для методов с аннотациями @ThisIsTest
            List<Method> thisIsTestList = new ArrayList<>();

            //перебираем методы с целью поиска искомых аннотаций
            for (Method m : methods
            ) {
                if (m.isAnnotationPresent(DoBeforeAll.class)) {
                    if (doBeforeAll != null) {
                        throw new RuntimeException("Дублирование аннотации DoBeforeAll");
                    }
                    doBeforeAll = m;
                }
                if (m.isAnnotationPresent(DoAfterAll.class)) {
                    if (doAfterAll != null) {
                        throw new RuntimeException("Дублирование аннотации DoAfterAll");
                    }
                    doAfterAll = m;
                }
                //если аннотация @ThisIsTest, то добавляем в список
                if (m.isAnnotationPresent(ThisIsTest.class)) {
                    thisIsTestList.add(m);
                }
            }

            //сортируем методы с аннотацией @ThisIsTest в порядке приоритетности
            thisIsTestList.sort(Comparator.comparingInt(a -> a.getDeclaredAnnotation(ThisIsTest.class).value()));

            //создаем экземпляр переданного класса для запуска его методов с помощью метода invoke
            Object testsClass = cl.getDeclaredConstructor().newInstance();

            //запускаем тесты в необходимом порядке и сохраняем результат выполнения в список
            String result;
            if (doBeforeAll != null) {
                result = (String) doBeforeAll.invoke(testsClass);
                resultList.add(result);
            }

            for (Method m : thisIsTestList
            ) {
                result = (String) m.invoke(testsClass);
                resultList.add(result);
            }

            if (doAfterAll != null) {
                result = (String) doAfterAll.invoke(testsClass);
                resultList.add(result);
            }

        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException
                | NullPointerException | NoSuchMethodException | InstantiationException ex) {
            ex.printStackTrace();
        }

        return resultList;
    }
}