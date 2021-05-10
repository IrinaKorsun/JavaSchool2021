package komissarov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    private Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testNotEmpty() throws QueueException {
        queue.enqueue(12);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testPushAndPop() throws QueueException {
        queue.enqueue(12);
        queue.enqueue(22);
        assertEquals(12, queue.dequeue());
        assertEquals(22, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testTop() throws QueueException {
        queue.enqueue(12);
        assertEquals(12, queue.top());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testDequeueWithException() {
        assertThrows(QueueException.class, () -> queue.dequeue(), "Очередь пуста");
    }

    @Test
    public void testTopWithException() {
        assertThrows(QueueException.class, () -> queue.top(), "Очередь пуста");
    }

    @Test
    public void testEnqueueQueueOverflow() throws QueueException {
        for (int i = 0; i <= 999; i++) {
            queue.enqueue(i);
        }
        assertThrows(QueueException.class, () -> queue.enqueue(1000), "Очередь переполнена");
    }
}
