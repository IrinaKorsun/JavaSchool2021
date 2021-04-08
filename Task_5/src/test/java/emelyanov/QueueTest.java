package emelyanov;

import org.junit.jupiter.api.Test;
import emelyanov.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    private static final int SIZE_QUEUE = 3;
    private Queue queue = new Queue(SIZE_QUEUE);

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void checkEnqueue() {
        Object object = "Object";
        queue.enqueue(object);
        assertEquals(queue.dequeue(), object);
    }

    @Test
    void checkDequeue() {
        Object obj = "Object";
        queue.enqueue(obj);
        assertEquals(queue.dequeue(), obj);
    }

    @Test
    void checkTop() {
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(9);
        assertEquals(queue.top(), 3);
    }

    @Test
    void checkOverflowQueue() {
        Object object = "Test";
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            for (int i = 0; i < SIZE_QUEUE + 1; i++) {
                queue.enqueue(object);
            }
        });
    }

    @Test
    void checkEmptyQueue() {
        assertNull(queue.top());
    }
}
