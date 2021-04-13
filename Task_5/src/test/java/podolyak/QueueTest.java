package podolyak;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private final int MAX_SIZE = 10_000;
    private Queue queue;

    @BeforeEach
    void createQueue() {
        queue = new Queue(MAX_SIZE);
    }


    @Test
    void testEnqueue() throws Exception {
        Object object = 10;
        queue.enqueue(object);
        Assertions.assertEquals(queue.top(), object);
    }

    @Test
    void testDequeue() throws Exception {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        Assertions.assertEquals(queue.top(), 1);
    }

    @Test
    void testExceptionDequeue() {
        assertThrows(Exception.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    void testExceptionTop() {
        assertThrows(Exception.class, () -> {
            queue.top();
        });
    }
}