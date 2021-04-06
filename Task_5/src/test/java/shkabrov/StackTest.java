package shkabrov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    @Test
    public void constructor1() {
        assertThrows(StackException.class, () -> {
            Stack stack = new Stack(1);
            stack.takeStackElements();
        });
    }

    @Test
    public void constructor2() throws StackException {
        Stack stack = new Stack(5, new Object[]{1, 2, 3, 4});
        Object[] fetchedStackElements = stack.takeStackElements();
        assertEquals(4, fetchedStackElements.length);
        Object[] testArray = new Object[]{1, 2, 3, 4};
        for (int i = 0; i < testArray.length; i++) {
            assertEquals(testArray[i], fetchedStackElements[i]);
        }
    }

    @Test
    public void incorrectInitializationOfStackSize() {
        assertThrows(StackException.class, () -> new Stack(0));
        assertThrows(StackException.class, () -> new Stack(257));
    }

    @Test
    public void invalidStackInitializationElements() {
        assertThrows(StackException.class, () -> new Stack(3, new Object[]{1, 2, 3, 4}));
        assertThrows(StackException.class, () -> new Stack(5, new Object[]{1, null, 3, 4}));
    }

    @Test
    public void push() throws StackException {
        assertThrows(StackException.class, () -> {
            Stack stack = new Stack(5, new Object[]{1, 2, 3, 4, 5});
            stack.push(6);
        });
        assertThrows(StackException.class, () -> {
            Stack stack = new Stack(5, new Object[]{1, 2, 3, 4});
            stack.push(null);
        });
        Stack stack1 = new Stack(5, new Object[]{});
        stack1.push("str");
        Object[] fetchedStackElements1 = stack1.takeStackElements();
        assertEquals("str", fetchedStackElements1[0]);
        Stack stack2 = new Stack(5, new Object[]{1, 2, 3});
        stack2.push("str");
        Object[] fetchedStackElements2 = stack2.takeStackElements();
        assertEquals("str", fetchedStackElements2[3]);
    }

    @Test
    public void pop() throws StackException {
        assertThrows(StackException.class, () -> {
            Stack stack = new Stack(5, new Object[]{});
            stack.pop();
        });
        Stack stack1 = new Stack(5, new Object[]{1, 2, 3, 4});
        Object fetchedElement = stack1.pop();
        assertEquals(3, stack1.top());
        assertEquals(4, fetchedElement);
        Stack stack2 = new Stack(5, new Object[]{1});
        stack2.pop();
        assertTrue(stack2.isEmpty());
    }

    @Test
    public void isEmpty() throws StackException {
        Stack stack1 = new Stack(5, new Object[]{});
        assertTrue(stack1.isEmpty());
        Stack stack2 = new Stack(5, new Object[]{1});
        assertFalse(stack2.isEmpty());
    }

    @Test
    public void top() throws StackException {
        assertThrows(StackException.class, () -> {
            Stack stack = new Stack(5, new Object[]{});
            stack.top();
        });
        Stack stack = new Stack(5, new Object[]{1, 2, 3});
        assertEquals(3, stack.top());
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
