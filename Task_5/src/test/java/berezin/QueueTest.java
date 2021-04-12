package berezin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    @Test
    public void enqueueTest() throws QueueStackException {
        Queue queue = new Queue(5);
        Object obj1 = 1;
        Object obj2 = 2;
        Object obj3 = 3;
        queue.enqueue(obj1);
        queue.enqueue(obj2);
        queue.enqueue(obj3);
        assertEquals(obj1, queue.top());
    }

    @Test
    public void enqueueTestError()  {
        Queue queue = new Queue(2);
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
        } catch (QueueStackException e) {
            assertEquals(ErrorCode.QUEUE_IS_FULL, e.getErrorCode());
        }
    }

    @Test
    public void dequeueErrorTest(){
        Queue queue = new Queue(3);
        try{
            queue.dequeue();
        }catch (QueueStackException e){
            assertEquals(ErrorCode.QUEUE_IS_EMPTY, e.getErrorCode());
        }
    }

    @Test
    public void isEmptyQueueTest(){
        Queue queue = new Queue(2);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isEmptyQueueTest2() throws QueueStackException {
        Queue queue = new Queue(2);
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void dequeueTest() throws QueueStackException {
        Queue queue = new Queue(2);
        queue.enqueue(1);
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }
}
