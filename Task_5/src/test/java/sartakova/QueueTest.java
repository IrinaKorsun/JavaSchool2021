package sartakova;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest  {

    @Test
    public void testEnqueue() throws Exception {
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertEquals(5, queue.getCurrentNumber());
    }


    @Test
    public void testDequeue() throws Exception {
        Queue queue = new Queue(5);
        queue.enqueue(4);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(6);
        queue.enqueue(8);
        assertEquals(5, queue.getCurrentNumber());
        assertEquals(4, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertEquals(3, queue.getCurrentNumber());
    }

    @Test
    public void testIsEmpty() {
        Queue queue = new Queue(10);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testGetBegin() throws Exception {
        Queue queue = new Queue(7);
        queue.enqueue("k");
        queue.enqueue("t");
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        assertEquals("k", queue.getBegin());
        assertEquals(7, queue.getCurrentNumber());
    }

    @Test()
    public void testEnqueueInFullQueue() throws Exception {
        Queue queue = new Queue(3);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        Assertions.assertThrows(Exception.class, () -> queue.enqueue("d"));
        assertEquals(3, queue.getCurrentNumber());
    }

    @Test
    public void testDequeueInEmptyQueue() {
        Queue queue = new Queue(8);
        Assertions.assertThrows(Exception.class, queue::dequeue);
    }

}

