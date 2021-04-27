package komissarov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testNotEmpty() {
        stack.push(12);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPushAndPop() {
        stack.push(12);
        assertEquals(12, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testTop() {
        stack.push(12);
        stack.push(21);
        stack.push(30);
        assertEquals(30, stack.top());
        stack.push(33);
        assertEquals(33, stack.top());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPopWithException() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    public void testTopWithException() {
        assertThrows(EmptyStackException.class, () -> stack.top());
    }

    @Test
    public void testPushStackOverflow() {
        for (int i = 0; i <= 999; i++) {
            stack.push(i);
        }
        assertThrows(StackOverflowError.class, () -> stack.push(1000));
    }
}