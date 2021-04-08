package emelyanov;

import org.junit.jupiter.api.Test;
import emelyanov.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    private static final int SIZE_STACK = 500;
    private Stack stack = new Stack(SIZE_STACK);

    @Test
    void checkEmptyPop() {
        stack = new Stack(1);
        Object obj = "Object";
        stack.push(obj);
        assertNull(stack.pop());
    }

    @Test
    void checkPush() {
        Object object = "Test";
        for (int i = 0; i < SIZE_STACK; i++) {
            stack.push(object);
        }
    }

    @Test
    void checkTop() {
        stack.push(3);
        stack.push(5);
        stack.push(9);
        assertEquals(stack.top(), 9);
    }

    @Test
    void checkOverflowStack() {
        Object object = "Test";
        assertThrows(IllegalStateException.class, () -> {
            for (int i = 0; i < 501; i++) {
                stack.push(object);
            }
        });
    }

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty());
    }

}
