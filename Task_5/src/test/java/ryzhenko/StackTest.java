package ryzhenko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @Test
    void testPush() throws Exception {
        stack.push("TestElement");
        assertFalse(stack.isEmpty());
    }

    @Test
    void testPop() throws Exception {
        stack.push("TestElement");
        assertEquals("TestElement", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void testTop() throws Exception {
        stack.push("TestElement");
        assertEquals("TestElement", stack.top());
        assertFalse(stack.isEmpty());
    }

    @Test
    void addInFullStack() {
        assertThrows(Exception.class,
                () -> {
                    for (int i = 0; i < 999; i++)
                        stack.push("TestElement");
                });
    }

    @Test
    void removeFromEmptyStack() {
        assertThrows(Exception.class,
                () -> {
                    stack.pop();
                });
    }
}