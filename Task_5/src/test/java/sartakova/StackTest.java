package sartakova;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StackTest {
    private Stack a = new Stack();
    private List<Object> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");

    @ParameterizedTest
    @MethodSource("listProvider")
    void testQueueFull(List<Object> list) throws Exception {
        for (Object elem : list) {
            a.push(elem);
        }
        Exception thrown = assertThrows(
                Exception.class,
                () -> a.push(11)
        );

        assertTrue(thrown.getMessage().contains("Ошибка! Стек переполнен"));  //Исключение при переполнении стека
    }

    static Stream<Arguments> listProvider() {
        return Stream.of(
                arguments(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")),
                arguments(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        );
    }
    @Test
    void testQueueEmpty() throws Exception {
        for (Object elem : list) {
            a.push(elem);
        }
        assertEquals("a; b; c; d; e; f; g; h; i; j", a.toString());
        assertEquals("j", a.pop());
        assertEquals("a; b; c; d; e; f; g; h; i", a.toString());
        a.push("k");//Добавляем элемент
        assertEquals("a; b; c; d; e; f; g; h; i; k", a.toString());// Проверка заполнения стека
        int current_number = a.getCurrent();
        for (int i = 0; i < current_number; i++) {
            a.pop(); //Удаление элементов из стека
        }
        Exception thrown = assertThrows(
                Exception.class,
                () -> a.pop()
        );
        assertTrue(thrown.getMessage().contains("Ошибка"));
    }

    @Test
    void testEmptyIsMethod() throws Exception {
        assertTrue(a.isEmpty());
        a.push(9);
        assertFalse(a.isEmpty());
    }

    @Test
    void testToStringMethod() throws Exception {
        a.push(10);
        a.push(9);
        assertEquals("10; 9", a.toString());
    }

    @Test
    void testTopMethod() throws Exception {
        a.push(1);
        a.push(2);
        assertEquals(2, a.top());
        a.push(22);
        assertEquals(22, a.top());
    }
}
