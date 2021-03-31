package mozzherin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private final int MAX_ARRAY_SIZE = 1000;
    private Stack stack = new Stack();

    @BeforeEach
    void setUp() throws QueueStackException {
        for (int i = 0; i < 100; i++) {
            assertTrue(stack.push("Element " + i));
        }
    }

    @Test
    void testPush() throws QueueStackException {
        assertTrue(stack.push("Element " + 101));
        assertEquals(stack.getSize(), 101);
    }

    @Test
    void testStackIsFull() {
        try {
            for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
                stack.push("Element " + i);
            }
        } catch (QueueStackException ex) {
            assertEquals(ErrorCode.IS_FULL, ex.getErrorCode());
        }
    }

    @Test
    void testPop() throws QueueStackException {
        for (int i = 0; i < 10; i++) {
            assertTrue(stack.pop());
        }
        assertEquals(stack.getSize(), 90);
    }

    @Test
    void testStackIsEmpty() {
        try {
            for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
                stack.pop();
            }
        } catch (QueueStackException ex) {
            assertEquals(ErrorCode.IS_EMPTY, ex.getErrorCode());
        }
    }

    @Test
    void testIsEmpty() throws QueueStackException {
        assertFalse(stack.isEmpty());
        for (int i = 0; i < 100; i++) {
            assertTrue(stack.pop());
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    void testTop() throws QueueStackException {
        assertEquals(stack.top(), "Element 99");
        assertTrue(stack.pop());
        assertEquals(stack.top(), "Element 98");
    }
}