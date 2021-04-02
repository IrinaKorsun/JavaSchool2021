package bakunov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStack {
    private Stack stack;
    private static final int SIZE_STACK = 500;

    @BeforeEach
    void setUp() {
        stack = new Stack(SIZE_STACK);
    }

    @Test
    void testPush() throws QueueStackException {
        Object obj = "Object";
        stack.push(obj);
        assertEquals(stack.pop(), obj);
    }

    @Test
    void testPushIsFull() {
        Object obj = "Object";
        try {
            for (int i = 0; i < SIZE_STACK + 5; i++){
                stack.push(obj);
            }
        } catch (QueueStackException ex) {
            assertEquals(ex.getErrorCode(), ErrorCode.IS_FULL);
        }
    }

    @Test
    void testPop() throws QueueStackException {
        Object obj = "Object";
        stack.push(obj);
        assertEquals(stack.pop(), obj);
    }

    @Test
    void testPopIsEmpty(){
            assertAll(
                    () -> assertTrue(stack.isEmpty()),
                    () -> assertNull(stack.pop())
            );
    }

    @Test
    void testIsEmpty() throws QueueStackException {
        assertTrue(stack.isEmpty());
        Object obj = "Object";
        stack.push(obj);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testTop() throws QueueStackException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        stack.push(obj1);
        stack.push(obj2);
        assertEquals(obj2, stack.top());
    }

    @Test
    void testTopIsEmpty(){
        assertAll(
                () -> assertTrue(stack.isEmpty()),
                () -> assertNull(stack.top())
        );
    }
}
