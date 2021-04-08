package mozzherin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private final int MAX_ARRAY_SIZE = 1000;
    private Queue queue = new Queue();

    @BeforeEach
    void setUp() throws QueueStackException {
        for (int i = 0; i < 100; i++) {
            assertTrue(queue.enqueue("Element " + i));
        }
    }

    @Test
    void testEnqueue() throws QueueStackException {
        assertTrue(queue.enqueue("Element " + 101));
        assertEquals(queue.getSize(), 101);
    }

    @Test
    void testQueueIsFull() {
        try {
            for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
                queue.enqueue("Element " + i);
            }
        } catch (QueueStackException ex) {
            assertEquals(ErrorCode.IS_FULL, ex.getErrorCode());
        }
    }

    @Test
    void testDequeue() throws QueueStackException{
        for (int i = 0; i < 10; i++) {
            assertTrue(queue.dequeue());
        }
        assertEquals(queue.getSize(), 90);
    }

    @Test
    void testQueueIsEmpty() {
        try {
            for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
                queue.dequeue();
            }
        } catch (QueueStackException ex) {
            assertEquals(ErrorCode.IS_EMPTY, ex.getErrorCode());
        }
    }

    @Test
    void testIsEmpty() throws QueueStackException{
        assertFalse(queue.isEmpty());
        for (int i = 0; i < 100; i++) {
            assertTrue(queue.dequeue());
        }
        assertTrue(queue.isEmpty());
    }

    @Test
    void testTop() throws QueueStackException {
        assertEquals(queue.top(), "Element 0");
        assertTrue(queue.dequeue());
        assertEquals(queue.top(), "Element 1");
    }
}