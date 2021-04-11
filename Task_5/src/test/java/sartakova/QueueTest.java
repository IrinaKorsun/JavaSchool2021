package sartakova;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest  {

    @Test
    public void testEnqueue() throws Exception {
        Queue queue = new Queue(5);
        for (int i = 1; i < queue.getCapacity(); i++) {
            queue.enqueue(i);
        }
        assertEquals(1, queue.getTop());
    }

    @Test
    public void testDequeue() throws Exception {
        Queue queue = new Queue(5);
        for (int i = 1; i < queue.getCapacity(); i++) {
            queue.enqueue(i);
        }
        assertEquals(4, queue.getSize());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(2, queue.getSize());
    }

    @Test
    public void testIsEmpty() {
        Queue queue = new Queue(10);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testGetSize() throws Exception {
        Queue queue = new Queue(5);
        for (char i = 'a'; i <= 'e'; i++) {
            queue.enqueue(i);
        }
        assertEquals('a', queue.getTop());
        assertEquals(5, queue.getSize());
    }

    @Test()
    public void testEnqueueInFullQueue() throws Exception {
        Queue queue = new Queue(3);
        for (char i = 'a'; i <= 'c'; i++) {
            queue.enqueue(i);
        }
        Assertions.assertThrows(Exception.class, () -> queue.enqueue("d"));
        assertEquals(3, queue.getSize());
    }

    @Test
    public void testDequeueInEmptyQueue() {
        Queue queue = new Queue(9);
        Assertions.assertThrows(Exception.class, queue::dequeue);
    }

}

