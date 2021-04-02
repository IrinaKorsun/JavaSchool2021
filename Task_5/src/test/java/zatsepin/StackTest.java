package zatsepin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @AfterEach
    void tearDown() {
        stack = null;
    }

    @Test
    void pushThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            stack.push(null);
        });
    }

    @Test
    void pushThrowsExceptionBecauseMaxSizeOfArrayReached() {
        assertThrows(Exception.class, () -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++)
                stack.push(9);
        });
    }

    @Test
    void popThrowsExceptionIfStackIsEmpty() {
        assertThrows(Exception.class, () -> {
            stack.pop();
        });
    }

    @Test
    void isEmptyReturnTrue() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void pop() throws Exception {
        stack.push(11);
        assertEquals(11, stack.pop());
    }

    @Test
    void top() throws Exception {
        stack.push(42);
        assertEquals(42, stack.top());
    }
}