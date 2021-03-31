package prikhozhaya;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack a = new Stack(5);

    @Test
    void push() {
        a.push(1);
        a.push(2);
        a.push("Э");
        a.push(4);
        a.push(5);
        Exception thrown = assertThrows(
                Exception.class,
                () -> a.push(6)
        );
        assertTrue(thrown.getMessage().contains("Стек переполнен"));
    }

    @Test
    void pop() {
        a.push(1);
        a.push(2);
        a.push(3);
        assertEquals(a.pop(), 3);
        assertEquals(a.toString(), "1 2 ");
        assertEquals(a.pop(), 2);
        assertEquals(a.toString(), "1 ");
        a.push(6);
        assertEquals(a.toString(), "1 6 ");
        assertEquals(a.pop(), 6);
        assertEquals(a.toString(), "1 ");
        assertEquals(a.pop(), 1);
        assertNull(a.pop());
    }

    @Test
    void isEmpty() {
        assertTrue(a.isEmpty());
        a.push(4);
        assertFalse(a.isEmpty());
    }

    @Test
    void top() {
        a.push(1);
        a.push(2);
        assertEquals(a.top(), 2);
        a.push(99);
        assertEquals(a.top(), 99);
    }

    @Test
    void testToString() {
        a.push(5);
        a.push(4);
        assertEquals(a.toString(), "5 4 ");
    }
}