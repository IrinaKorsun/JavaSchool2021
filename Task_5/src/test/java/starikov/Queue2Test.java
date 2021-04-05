package starikov;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Queue2Test {

    Queue2 queue2 = new Queue2(10);

    @Test
    void isEmpty() {
        assertTrue(queue2.isEmpty());

        queue2.enqueue(null);
        assertTrue(queue2.isEmpty());

        queue2.enqueue(25);
        assertFalse(queue2.isEmpty());

        queue2.top();
        assertFalse(queue2.isEmpty());

        queue2.dequeue();
        assertTrue(queue2.isEmpty());
    }

    @Test
    void top() {
        queue2.enqueue(1);
        assertEquals(1, queue2.top());

        queue2.enqueue(2);
        assertEquals(1, queue2.top());

        queue2.dequeue();
        queue2.dequeue();
        assertThrows(StackAndQueueException.class, () -> queue2.top());
    }

    @Test
    void dequeue() {
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);

        queue2.dequeue();
        assertEquals(2, queue2.getQueue()[0]);
        assertEquals(3, queue2.getQueue()[1]);
        assertNull(queue2.getQueue()[2]);

        queue2.dequeue();
        assertEquals(3, queue2.getQueue()[0]);
        assertNull(queue2.getQueue()[1]);
    }

    @Test
    void enqueue() {
        for (int i = 1; i < queue2.getQueue().length + 1; i++) {
            queue2.enqueue(i);
        }

        assertEquals(2, queue2.getQueue()[1]);
        assertEquals(3, queue2.getQueue()[2]);

        assertThrows(StackAndQueueException.class, () -> queue2.enqueue(11));

        queue2.dequeue();
        queue2.dequeue();

        queue2.enqueue(11);
        assertEquals(11, queue2.getQueue()[8]);

        queue2.enqueue(12);
        assertEquals(12, queue2.getQueue()[9]);

        assertThrows(StackAndQueueException.class, () -> queue2.enqueue(13));
    }

    @Test
    void manyTimesEnqueueAndDequeue() {
        boolean flag = false;

        for (int i = 0; i < 1000000; i++) {

            if (i % queue2.getQueue().length == 0) {
                flag = !flag;
            }

            if (flag) {
                queue2.enqueue(i);
            } else {
                queue2.dequeue();
            }

            if (i < 100) {
                System.out.println(Arrays.toString(queue2.getQueue()));
            }
        }
    }
}