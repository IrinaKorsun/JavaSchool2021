package shakina;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shakina.exception.MyException;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @Test
    public void testEnqueue() throws MyException {
        MyQueue queue = new MyQueue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.getCurrentSize());
    }


    @Test
    public void testDequeue() throws MyException {
        MyQueue queue = new MyQueue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.getCurrentSize());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.getCurrentSize());
    }

    @Test
    public void testIsEmpty() {
        MyQueue queue = new MyQueue(5);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testGetHead() throws MyException {
        MyQueue queue = new MyQueue(5);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        assertEquals("a", queue.getHead());
        assertEquals(5, queue.getCurrentSize());
    }

    @Test()
    public void testEnqueueInFullQueue() throws MyException {
        MyQueue queue = new MyQueue(3);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        Assertions.assertThrows(MyException.class, () -> queue.enqueue("d"));
    }

    @Test
    public void testDequeueInEmptyQueue() {
        MyQueue queue = new MyQueue(7);
        Assertions.assertThrows(MyException.class, queue::dequeue);
    }

}