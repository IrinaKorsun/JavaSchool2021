package prikhozhaya;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class QueueTest {
    private Queue a = new Queue();
    private List<Object> list = Arrays.asList("a", "b", "c", "d", "e");

    @ParameterizedTest
    @MethodSource("listProvider")
    void testEnqueueMethod(List<Object> list) throws Exception {
        for (Object elem : list) {
            a.enqueue(elem); //Заполняем очередь элементами с различными типами данных
        }
        Exception thrown = assertThrows(
                Exception.class,
                () -> a.enqueue(6)
        );
        //Если очередь переполнена, а пользователь продолжает добавлять элементы, кидаем исключение
        assertTrue(thrown.getMessage().contains("Очередь переполнена"));
    }

    static Stream<Arguments> listProvider() {
        return Stream.of(
                arguments(Arrays.asList("a", "b", "c", "d", "e")),
                arguments(Arrays.asList(1, 2, 3, 4, 5))
        );
    }

    @Test
    void testDequeueMethod() throws Exception {
        for (Object elem : list) {
            a.enqueue(elem);
        }
        assertEquals("a; b; c; d; e", a.toString());
        a.dequeue();
        assertEquals( "b; c; d; e", a.toString());
        a.enqueue("f"); //Добавляем в конец очереди
        assertEquals("b; c; d; e; f", a.toString());// Проверяем корректно ли заполнилась очередь
        assertEquals("b", a.top()); // Проверяем корректно ли заполнилась очередь
        int quantity = a.getnQuantity();
        for (int i = 0; i < quantity; i++) {
            a.dequeue(); //Очищаем очередь
        }
        //Если очередь пуста, а пользователь продолжает удалять элементы, кидаем исключение
        Exception thrown = assertThrows(
                Exception.class,
                () -> a.dequeue()
        );
        assertTrue(thrown.getMessage().contains("Очередь пуста"));
    }

    @Test
    void testIsEmptyMethod() throws Exception {
        assertTrue(a.isEmpty());
        a.enqueue(4);
        assertFalse(a.isEmpty());
    }

    @Test
    void testTopMethod() throws Exception {
        a.enqueue(5);
        a.enqueue(4);
        assertEquals(5, a.top());
        a.dequeue();
        assertEquals(4, a.top());
        a.enqueue(8);
        assertEquals(4, a.top());
    }

    @Test
    void testToStringMethod() throws Exception {
        a.enqueue(5);
        a.enqueue(4);
        assertEquals("5; 4", a.toString());
    }
}