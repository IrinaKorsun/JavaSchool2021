package lesnoy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStack {
    private static final int STACK_SIZE = 200;
    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack(STACK_SIZE);
    }

    @Test
    void testPush() throws Exception {
        Object obj = "Object";
        stack.push(obj);
        Assertions.assertEquals(stack.pop(), obj);
    }

    @Test
    void pushIsFull() throws Exception {
        Object obj = "Object";
        for (int i = 0; i < STACK_SIZE; i++) {
            stack.push(obj);
        }
        Exception ex = assertThrows(
                Exception.class,
                () -> stack.push(obj)
        );
        System.out.println(ex.getMessage());
        assertTrue(ex.getMessage().contains("Место в стеке закончилось!"));
    }


    @Test
    void testPop() throws Exception {
        Object obj = "Object";
        stack.push(obj);
        Assertions.assertEquals(stack.pop(), obj);
    }

    @Test
    void testIsEmpty() throws Exception {
        assertTrue(stack.isEmpty());
        Object obj = "Object";
        stack.push(obj);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testTop() {
        assertAll(
                () -> assertTrue(stack.isEmpty()),
                () -> assertNull(stack.top())
        );
    }
}