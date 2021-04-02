package prikhozhaya;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StackTest {
    private Stack a = new Stack();
    private List<Object> list = Arrays.asList("a", "b", "c", "d", "e");

    @ParameterizedTest
    @MethodSource("listProvider")
    public void testPushMethod(List<Object> list) throws Exception {
        for (Object elem : list) {
            a.push(elem); //Заполняем стек элементами с различными типами данных
        }
        Exception thrown = assertThrows(
                Exception.class,
                () -> a.push(6)
        );
        //Если стек переполнен, а пользователь продолжает добавлять элементы, кидаем исключение
        assertTrue(thrown.getMessage().contains("Стек переполнен"));
    }

    static Stream<Arguments> listProvider() {
        return Stream.of(
                arguments(Arrays.asList("a", "b", "c", "d", "e")),
                arguments(Arrays.asList(1, 2, 3, 4, 5))
        );
    }

    @Test
    void testPopMethod() throws Exception {
        for (Object elem : list) {
            a.push(elem);
        }
        assertEquals("a; b; c; d; e", a.toString());

        assertEquals("e", a.pop());
        assertEquals("a; b; c; d", a.toString());
        a.push("h");//Добавляем элемент
        assertEquals("a; b; c; d; h", a.toString());// Проверяем корректно ли заполнился стек
        int quantity = a.getQuantity();
        for (int i = 0; i < quantity; i++) {
            a.pop(); //Очищаем стек
        }
        //Если стек пуст, а пользователь продолжает удалять элементы, кидаем исключение
        Exception thrown = assertThrows(
                Exception.class,
                () -> a.pop()
        );
        assertTrue(thrown.getMessage().contains("Стек пуст"));
    }

    @Test
    void testIsEmptyMethod() throws Exception {
        assertTrue(a.isEmpty());
        a.push(4);
        assertFalse(a.isEmpty());
    }

    @Test
    void testTopMethod() throws Exception {
        a.push(1);
        a.push(2);
        assertEquals(2, a.top());
        a.push(99);
        assertEquals(99, a.top());
    }

    @Test
    void testToStringMethod() throws Exception {
        a.push(5);
        a.push(4);
        assertEquals("5; 4", a.toString());
    }
}