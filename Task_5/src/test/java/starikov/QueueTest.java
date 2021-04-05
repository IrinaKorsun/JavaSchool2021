package starikov;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    Queue queue = new Queue(10);

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());

        queue.enqueue(null);
        assertTrue(queue.isEmpty());

        queue.enqueue(25);
        assertFalse(queue.isEmpty());

        queue.top();
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void top() {
        queue.enqueue(1);
        assertEquals(1, queue.top());

        queue.enqueue(2);
        assertEquals(1, queue.top());

        queue.dequeue();
        queue.dequeue();
        assertThrows(StackAndQueueException.class, () -> queue.top());
    }

    @Test
    void enqueue() {
        //заполняем очередь "под завязку"
        for (int i = 1; i < queue.getQueue().length + 1; i++) {
            queue.enqueue(i);
        }

        assertEquals(2, queue.getQueue()[1]);
        assertEquals(3, queue.getQueue()[2]);

        assertThrows(StackAndQueueException.class, () -> queue.enqueue(11));

        //осовождаем первые элементы
        queue.dequeue();
        queue.dequeue();

        //вставляем элементы на освободившиеся места
        queue.enqueue(11);
        assertEquals(11, queue.getQueue()[0]);

        queue.enqueue(12);
        assertEquals(12, queue.getQueue()[1]);

        assertThrows(StackAndQueueException.class, () -> queue.enqueue(13));
    }

    @Test
    void dequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.dequeue();
        assertNull(queue.getQueue()[0]);

        queue.dequeue();
        assertNull(queue.getQueue()[1]);
    }

    @Test
    void manyTimesEnqueueAndDequeue() {
        int i = 0;

        for (; i < queue.getQueue().length - 2; i++) {
            queue.enqueue(i);
        }

        System.out.println(Arrays.toString(queue.getQueue()));

        for (; i < 1000000; i++) {
            queue.enqueue(i);
            queue.dequeue();

            if (i < 100) {
                System.out.println(Arrays.toString(queue.getQueue()));
            }
        }
    }
}