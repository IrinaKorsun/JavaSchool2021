package shkabrov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    @Test
    public void constructor1() {
        assertThrows(QueueException.class, () -> {
            Queue queue = new Queue(1);
            queue.takeQueueElements();
        });
    }

    @Test
    public void constructor2() throws QueueException {
        Queue queue = new Queue(5, new Object[]{1, 2, 3, 4});
        Object[] fetchedQueueElements = queue.takeQueueElements();
        assertEquals(4, fetchedQueueElements.length);
        Object[] testArray = new Object[]{1, 2, 3, 4};
        for (int i = 0; i < testArray.length; i++) {
            assertEquals(testArray[i], fetchedQueueElements[i]);
        }
    }

    @Test
    public void incorrectInitializationOfQueueSize() {
        assertThrows(QueueException.class, () -> new Queue(0));
        assertThrows(QueueException.class, () -> new Queue(1025));
    }

    @Test
    public void invalidQueueInitializationElements() {
        assertThrows(QueueException.class, () -> new Queue(3, new Object[]{1, 2, 3, 4}));
        assertThrows(QueueException.class, () -> new Queue(5, new Object[]{1, null, 3, 4}));
    }

    @Test
    public void enQueue() throws QueueException {
        assertThrows(QueueException.class, () -> {
            Queue queue = new Queue(5, new Object[]{1, 2, 3, 4, 5});
            queue.enQueue(6);
        });
        assertThrows(QueueException.class, () -> {
            Queue queue = new Queue(5, new Object[]{1, 2, 3, 4});
            queue.enQueue(null);
        });
        Queue queue1 = new Queue(5, new Object[]{});
        queue1.enQueue("str");
        Object[] fetchedQueueElements1 = queue1.takeQueueElements();
        assertEquals("str", fetchedQueueElements1[0]);
        Queue queue2 = new Queue(5, new Object[]{1, 2, 3});
        queue2.enQueue("str");
        Object[] fetchedQueueElements2 = queue2.takeQueueElements();
        assertEquals("str", fetchedQueueElements2[3]);
    }

    @Test
    public void deQueue() throws QueueException {
        assertThrows(QueueException.class, () -> {
            Queue queue = new Queue(5, new Object[]{});
            queue.deQueue();
        });
        Queue queue = new Queue(5, new Object[]{1, 2, 3, 4});
        queue.deQueue();
        assertEquals(2, queue.top());
    }

    @Test
    public void isEmpty() throws QueueException {
        Queue queue1 = new Queue(5, new Object[]{});
        assertTrue(queue1.isEmpty());
        Queue queue2 = new Queue(5, new Object[]{1});
        assertFalse(queue2.isEmpty());
    }

    @Test
    public void top() throws QueueException {
        assertThrows(QueueException.class, () -> {
            Queue queue = new Queue(5, new Object[]{});
            queue.top();
        });
        Queue queue1 = new Queue(5, new Object[]{1, 2, 3});
        assertEquals(1, queue1.top());
        Queue queue2 = new Queue(3, new Object[]{1, 2, 3});
        queue2.deQueue();
        queue2.enQueue(4);
        assertEquals(2, queue2.top());
        queue2.deQueue();
        queue2.enQueue(5);
        queue2.deQueue();
        queue2.enQueue(6);
        assertEquals(4, queue2.top());
    }

    @Test
    public void stabilityCheck() {
        int maxIterations = 1000000;
        try {
            Queue queue = new Queue(5, new Object[]{1, 2, 3, 4});
            for (int i = 0; i <= maxIterations; i++) {
                int operation = NumberOperations.calculateRandomNumber(1, 5);
                double randomNumberForEnQueue = NumberOperations.calculateRandomNumber(0, 11);
                try {
                    switch (operation) {
                        case 1:
                            queue.enQueue(randomNumberForEnQueue);
                            break;
                        case 2:
                            queue.deQueue();
                            break;
                        case 3:
                            queue.isEmpty();
                            break;
                        case 4:
                            queue.top();
                            break;
                    }
                } catch (QueueException qe) {
                    if (qe.getErrorCode() == QueueErrorCode.QUEUE_FULL) {
                        System.out.println(qe.getErrorCode().getErrorString());
                    } else if (qe.getErrorCode() == QueueErrorCode.QUEUE_EMPTY) {
                        System.out.println(qe.getErrorCode().getErrorString());
                    } else if (qe.getErrorCode() == QueueErrorCode.QUEUE_NULL_ELEMENT) {
                        System.out.println(qe.getErrorCode().getErrorString());
                    }
                }
            }
        } catch (QueueException qe) {
            if (qe.getErrorCode() == QueueErrorCode.QUEUE_INSUFFICIENT_SIZE) {
                System.out.println(qe.getErrorCode().getErrorString());
            } else if (qe.getErrorCode() == QueueErrorCode.QUEUE_INCORRECT_SIZE) {
                System.out.println(qe.getErrorCode().getErrorString());
            } else if (qe.getErrorCode() == QueueErrorCode.QUEUE_MAX_SIZE_EXCEEDED) {
                System.out.println(qe.getErrorCode().getErrorString());
            } else if (qe.getErrorCode() == QueueErrorCode.QUEUE_NULL_ELEMENT) {
                System.out.println(qe.getErrorCode().getErrorString());
            }
        }
    }
}
