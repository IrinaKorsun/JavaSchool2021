package khoroshev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @Test
    void pushTestAddNull() {
        assertThrows(StackException.class, () -> stack.push(null));
    }

    @Test
    void pushTestOverflowingStack() throws StackException {
        for (int i = 0; i < 10000; i++) {
            stack.push(1);
        }
        assertThrows(StackException.class, () -> stack.push(1));
    }

    @Test
    void pushTestOverflowingStackWithAdjustedSize() throws StackException {
        stack = new Stack(new Object[10]);
        for (int i = 0; i < 10; i++) {
            stack.push(1);
        }
        assertEquals(10, stack.getSize());
        assertThrows(StackException.class, () -> stack.push(1));
    }

    @Test
    void popTestEmpty() {
        assertThrows(StackException.class, () -> stack.pop());
    }

    @Test
    void popTestNotEmpty() throws StackException {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        for (int i = 9; i > -1; i--) {
            if ((int)stack.pop() != i) {
                fail();
            }
        }
        assertEquals(0, stack.getSize());
    }

    @Test
    void isEmptyTestTrue() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void isEmptyTestFalse() throws StackException {
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void topTestEmpty() {
        assertThrows(StackException.class, () -> stack.top());
    }

    @Test
    void topTestNotEmpty() throws StackException {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        for (int i = 0; i < 10; i++) {
            if ((int)stack.top() != 9) {
                fail();
            }
        }
        assertEquals(10, stack.getSize());
    }
}