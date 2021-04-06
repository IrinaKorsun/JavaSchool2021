package bakunov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestQueue {

    private static final int SIZE_QUEUE = 500;
    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue(SIZE_QUEUE);
    }

    @Test
    void testEnqueue() throws QueueStackException, Exception {
        Object obj = "Object";
        queue.enqueue(obj);
        assertEquals(queue.dequeue(), obj);
    }

    @Test
    void testEnqueueIsFull() {
        Object obj = "Object";
        try {
            for (int i = 0; i < SIZE_QUEUE + 5; i++) {
                queue.enqueue(obj);
            }
        } catch (QueueStackException ex) {
            assertEquals(ErrorCode.IS_FULL, ex.getErrorCode());
        }
    }

    @Test
    void testDequeue() throws QueueStackException, Exception {
        Object obj = "Object";
        queue.enqueue(obj);
        assertEquals(queue.dequeue(), obj);
    }

    @Test
    void testDequeueIsEmpty() {
        assertAll(
                () -> assertTrue(queue.isEmpty()),
                () -> assertNull(queue.dequeue())
        );
    }

    @Test
    void testIsEmpty() throws QueueStackException, Exception {
        assertTrue(queue.isEmpty());
        Object obj = "Object";
        queue.enqueue(obj);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void testGetTop() throws QueueStackException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        queue.enqueue(obj1);
        queue.enqueue(obj2);
        assertEquals(obj1, queue.top());
    }

    @Test
    void getTopIsEmpty() {
        assertAll(
                () -> assertTrue(queue.isEmpty()),
                () -> assertNull(queue.top())
        );
    }
}
