package Volodin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private static final int SIZE_STACK = 1000;
    private Stack stack = new Stack(SIZE_STACK);

    @Test
    void push() {
        Object testObject = "666";
        for (int i = 0; i < SIZE_STACK; i++) {
            stack.push(testObject);
        }
    }

    @Test
    void pop() {
        stack = new Stack(1);
        int m = 1;
        stack.push(m);
        assertNull(stack.pop());
    }

    @Test
    void top() {
        stack.push(3);
        stack.push(2);
        stack.push(5);
        assertEquals(stack.top(), 5);
    }

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void pushIsFull() throws Exception {
        Object m = "666";
        for (int i = 0; i < SIZE_STACK; i++) {
            stack.push(m);
        }
        Exception ex = assertThrows(
                Exception.class, () -> stack.push(m)
        );
        System.out.println(ex.getMessage());
        assertTrue(ex.getMessage().contains("Места в стэке больше нет, ухади!"));
    }

}