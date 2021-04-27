package prikhozhaya;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import prikhozhaya.annotations.ThisIsTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassTesting2Test {
    private static Class<ClassTesting2> classTesting = ClassTesting2.class;//Тестируемый класс
    private static Method method;//Метод тестируемого класса
    private static List<String> doneTest = new ArrayList<>();//Содержит сведения о запущенных методах и их очередности

    @BeforeAll
    static void beforeAll() throws Exception {
        doneTest = StartTest.start(classTesting);
    }

    @Test
    void testMethod1() throws NoSuchMethodException {
        method = classTesting.getMethod("testMethod1");//Получаем конкретный метод
        assertTrue(method.getAnnotation(ThisIsTest.class) != null);//Проверяем установленна ли над этим методом нужная нам аннотания
        assertTrue(doneTest.contains(method.getName()));//Проверяем был ли запущен метод
    }

    @Test
    void testMethod2() throws NoSuchMethodException {
        method = classTesting.getMethod("testMethod2");
        assertTrue(method.getAnnotation(ThisIsTest.class) != null);
        assertTrue(doneTest.contains(method.getName()));
    }

    @Test
    void testMethod3() throws NoSuchMethodException {
        method = classTesting.getMethod("testMethod3");
        assertTrue(method.getAnnotation(ThisIsTest.class) != null);
        assertTrue(doneTest.contains(method.getName()));
    }
}