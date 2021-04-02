package zatsepin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue();
    }

    @AfterEach
    void tearDown() {
        queue = null;
    }

    @Test
    void enqueueThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            queue.enqueue(null);
        });
    }

    @Test
    void enqueueThrowsExceptionBecauseMaxSizeOfArrayReached() {
        assertThrows(Exception.class, () -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++)
                queue.enqueue(9);
        });
    }

    @Test
    void dequeueThrowsExceptionIfStackIsEmpty() {
        assertThrows(Exception.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    void isEmptyReturnTrue() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void dequeue() throws Exception {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
    }

    @Test
    void top() throws Exception {
        queue.enqueue(9);
        queue.enqueue(2);
        assertEquals(9, queue.top());
    }
}