package prikhozhaya;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue a = new Queue(5);

    @Test
    void enqueue() {
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        a.enqueue(4);
        a.enqueue(5);
        Exception thrown = assertThrows(
                Exception.class,
                () -> a.enqueue(6)
        );
        assertTrue(thrown.getMessage().contains("Очередь переполнена"));
    }

    @Test
    void dequeue() {
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        a.enqueue(4);
        a.enqueue(5);
        assertEquals(a.toString(), "1 2 3 4 5 ");
        a.dequeue();
        a.dequeue();
        assertEquals(a.toString(), "3 4 5 ");
        a.enqueue(6);
        a.enqueue(7);
        assertEquals(a.toString(), "6 7 3 4 5 ");
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
    }

    @Test
    void isEmpty() {
        assertTrue(a.isEmpty());
        a.enqueue(4);
        assertFalse(a.isEmpty());
    }

    @Test
    void top() {
        a.enqueue(5);
        a.enqueue(4);
        assertEquals(a.top(), 5);
        a.dequeue();
        assertEquals(a.top(), 4);
        a.enqueue(8);
        assertEquals(a.top(), 4);
    }

    @Test
    void testToString() {
        a.enqueue(5);
        a.enqueue(4);
        assertEquals(a.toString(), "5 4 ");
    }
}