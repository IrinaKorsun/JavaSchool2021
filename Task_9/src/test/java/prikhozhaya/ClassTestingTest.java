package prikhozhaya;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import prikhozhaya.annotations.DoAfterAll;
import prikhozhaya.annotations.DoBeforeAll;
import prikhozhaya.annotations.ThisIsTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClassTestingTest {
    private static Class<ClassTesting> classTesting = ClassTesting.class;//Тестируемый класс
    private static Method method;//Метод тестируемого класса
    private static List<String> doneTest = new ArrayList<>();//Содержит сведения о запущенных методах и их очередности

    @BeforeAll
    static void beforeAll() throws Exception {
        doneTest = StartTest.start(classTesting);
    }

    @Test
    void testMethod2() throws NoSuchMethodException {
        method = classTesting.getMethod("testMethod2");//Получаем конкретный метод
        assertTrue(method.getAnnotation(ThisIsTest.class) != null);//Проверяем установленна ли над этим методом нужная нам аннотания
        assertEquals(method.getAnnotation(ThisIsTest.class).priority(), doneTest.indexOf(method.getName()));//Проверяем в правильном ли поредке были запущены методы, помеченные соответствующими аннотациями
    }

    @Test
    void testMethod1() throws NoSuchMethodException {
        method = classTesting.getMethod("testMethod1");
        assertTrue(method.getAnnotation(ThisIsTest.class) != null);
        assertEquals(method.getAnnotation(ThisIsTest.class).priority(), doneTest.indexOf(method.getName()));
    }

    @Test
    void testMethod3() throws NoSuchMethodException {
        method = classTesting.getMethod("testMethod3");
        assertTrue(method.getAnnotation(ThisIsTest.class) != null);
        assertEquals(method.getAnnotation(ThisIsTest.class).priority(), doneTest.indexOf(method.getName()));
    }

    @Test
    void afterAllMethod() throws NoSuchMethodException {
        method = classTesting.getMethod("afterAllMethod");
        assertTrue(method.getAnnotation(DoAfterAll.class) != null);
        assertEquals((doneTest.size() - 1), doneTest.indexOf(method.getName()));
    }

    @Test
    void beforeAllMethod() throws NoSuchMethodException {
        method = classTesting.getMethod("beforeAllMethod");
        assertTrue(method.getAnnotation(DoBeforeAll.class) != null);
        assertEquals(0, doneTest.indexOf(method.getName()));
    }
}