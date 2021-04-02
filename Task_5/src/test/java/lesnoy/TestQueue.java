package lesnoy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestQueue {
    private static final int QUEUE_SIZE = 200;
    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue(QUEUE_SIZE);
    }

    @Test
    void enqueue() throws Exception {
        Object obj = "Object";
        queue.enqueue(obj);
        Assertions.assertEquals(queue.dequeue(), obj);
    }

    @Test
    void enqueueIsFull() throws Exception {
        Object obj = "Object";
        for (int i = 0; i < QUEUE_SIZE; i++) {
            queue.enqueue(obj);
        }
        Exception ex = assertThrows(
                Exception.class,
                () -> queue.enqueue(obj)
        );
        System.out.println(ex.getMessage());
        assertTrue(ex.getMessage().contains("Место в очереди закончилось!"));
    }

    @Test
    void dequeue() throws Exception {
        Object obj = "Object";
        queue.enqueue(obj);
        Assertions.assertEquals(queue.dequeue(), obj);
    }

    @Test
    void isEmpty() throws Exception {
        assertTrue(queue.isEmpty());
        Object obj = "Object";
        queue.enqueue(obj);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void top() {
        assertAll(
                () -> assertTrue(queue.isEmpty()),
                () -> assertNull(queue.top())
        );
    }
}

