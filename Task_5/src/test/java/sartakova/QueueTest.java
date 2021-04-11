package sartakova;
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
    private List<Object> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");

    @ParameterizedTest
    @MethodSource("listProvider")
    void testQueueIsFull(List<Object> list) throws Exception {
        for (Object elem : list) {
            a.enqueue(elem);
        }
        Exception thrown = assertThrows(
                Exception.class,
                () -> a.enqueue(11)
        );

        assert(thrown.getMessage().contains("Ошибка! Очередь переполнена"));  //Исключение при переполнении очереди
    }

    static Stream<Arguments> listProvider() {
        return Stream.of(
                arguments(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")),
                arguments(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        );
    }

    @Test
    void testQueueIsEmpty() throws Exception {
        for (Object elem : list) {
            a.enqueue(elem);
        }
        assertEquals("a; b; c; d; e; f; g; h; i; j", a.toString());
        a.dequeue();
        assertEquals( "b; c; d; e; f; g; h; i; j", a.toString());
        a.enqueue("k"); //Добавляем в конец очереди
        assertEquals("b; c; d; e; f; g; h; i; j; k", a.toString());// Проверка заполнения очереди
        assertEquals("b", a.top()); // Проверка заполнения очереди
        int current_number = a.getCurrent();
        for (int i = 0; i < current_number; i++) {
            a.dequeue(); //Удаление элементов из очереди
        }
        Exception thrown = assertThrows(
                Exception.class,
                () -> a.dequeue()
        );
        assertTrue(thrown.getMessage().contains("Ошибка! Очередь пуста"));
    }
    @Test
    void testEmptyMethod() throws Exception {
        assertTrue(a.isEmpty());
        a.enqueue(9);
        assertFalse(a.isEmpty());
    }
    @Test
    void testTopMethod() throws Exception {
        a.enqueue(10);
        a.enqueue(9);
        assertEquals(10, a.top());
        a.dequeue();
        assertEquals(9, a.top());
        a.enqueue(13);
        assertEquals(9, a.top());
    }

    @Test
    void testToStringMethod() throws Exception {
        a.enqueue(10);
        a.enqueue(9);
        assertEquals("10; 9", a.toString());
    }
}

