package Volodin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private static final int SIZE_QUEUE = 1000;
    private Queue queue = new Queue(SIZE_QUEUE);

    @Test
    void enqueue() {
        Object test = "test";
        queue.enqueue(test);
        assertEquals(queue.dequeue(), test);
    }

    @Test
    void dequeue() {
        Object test2 = "test";
        queue.enqueue(test2);
        assertEquals(queue.dequeue(), test2);
    }

    @Test
    void top() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(13);
        assertEquals(queue.top(), 1);
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void emptyQueue() {
        assertNull(queue.top());
    }

    @Test
    void overflowQueue() {
        Object test = "test";
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            for (int i = 0; i < SIZE_QUEUE + 1; i++){
                queue.enqueue(test);
            }
        });
    }
}