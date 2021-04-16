package ryzhenko;

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
    void testEnqueue() throws Exception {
        queue.enqueue("TestElement");
        assertFalse(queue.isEmpty());
    }

    @Test
    void testDequeue() throws Exception {
        queue.enqueue("TestElement");
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void testTop() throws Exception {
        queue.enqueue("TestElement1");
        queue.enqueue("TestElement2");
        assertEquals("TestElement1", queue.top());
    }

    @Test
    void TestOffsetArray() throws Exception {
        for (int i = 0; i < 100; i++) {
            queue.enqueue("TestElement");
        }
        queue.dequeue();
        queue.enqueue("TestElement");
    }

    @Test
    void addInFullQueue() {
        assertThrows(Exception.class,
                () -> {
                    for (int i = 0; i < 999; i++)
                        queue.enqueue("TestElement");
                });
    }

    @Test
    void removeFromEmptyQueue() {
        assertThrows(Exception.class,
                () -> {
                    queue.dequeue();
                });
    }
}