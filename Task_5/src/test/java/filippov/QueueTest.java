package filippov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueTest {

    private final int targetSize = 1_000_000;   //Тестовый размер данных

    @Test
    void enqueue() throws QueueExceptionOversize {
        Queue q = new Queue();
        for (int i = 0; i < targetSize; i++)
            q.enqueue(i);

    }

    @Test
    void dequeue() throws QueueExceptionOversize {
        Queue q = new Queue();
        for (int i = 0; i < targetSize; i++)
            q.enqueue(i);
        while (!q.isEmpty()) {
            q.dequeue();
        }
    }

    @Test
    void isEmpty() throws QueueExceptionOversize {
        Queue q = new Queue();
        Assertions.assertTrue(q.isEmpty());
        q.enqueue(1);
        Assertions.assertFalse(q.isEmpty());
        q.dequeue();
        Assertions.assertTrue(q.isEmpty());
        for (int i = 0; i < targetSize; i++)
            q.enqueue(i);
        Assertions.assertFalse(q.isEmpty());
    }

    @Test
    void top() throws QueueExceptionOversize {
        Queue q = new Queue();
        Object testObject = "Test";
        Assertions.assertNull(q.top());
        q.enqueue(testObject);
        Assertions.assertEquals(testObject, q.top());
        q.dequeue();
        Assertions.assertNull(q.top());
    }
}

