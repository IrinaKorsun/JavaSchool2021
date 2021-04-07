package khoroshev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    private Queue queue;


    @BeforeEach
    void setUp() {
        queue = new Queue();
    }

    @Test
    void enqueueTestAddNull() {
        assertThrows(QueueException.class, () -> queue.enqueue(null));
    }

    @Test
    void enqueueTestOverflowingQueue() throws QueueException {
        for (int i = 0; i < 10000; i++) {
            queue.enqueue("!");
        }
        assertThrows(QueueException.class, () -> queue.enqueue(1));
    }

    @Test
    void enqueueTestOverflowingQueueWithAdjustedSize() throws QueueException {
        queue = new Queue(new Object[10]);
        for (int i = 0; i < 10; i++) {
            queue.enqueue("!");
        }
        assertThrows(QueueException.class, () -> queue.enqueue(1));
    }

    @Test
    void dequeueTestIsEmpty() {
        assertThrows(QueueException.class, () -> queue.dequeue());
    }

    @Test
    void isEmptyTestTrue() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void isEmptyTestFalse() throws QueueException {
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    void topTestEmpty() {
        assertThrows(QueueException.class, () -> queue.top());
    }

    @Test
    void topTestNotEmpty() throws QueueException {
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 20; i++) {
            if ((int) queue.top() != 0) {
                fail();
            }
        }
        assertEquals(20, queue.getSize());
    }

}
