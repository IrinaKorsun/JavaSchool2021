package filippov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private final int targetSize = 10;   //Тестовый размер данных

    @Test
    void push() throws QueueExceptionOversize  {
        Stack s = new Stack();
        assertTrue(s.isEmpty());
        for (int i = 0; i < targetSize; i++)
            s.push(i);
        assertFalse(s.isEmpty());

    }

    @Test
    void pop() throws QueueExceptionOversize {
        Stack s = new Stack();
        assertTrue(s.isEmpty());
        for (int i = 0; i < targetSize; i++)
            s.push(i);
        for (int i = targetSize; i > 0; i--)
            assertEquals(i - 1, s.pop());
        for (int i = 0; i < targetSize; i++)
            s.push(i);
        while (!s.isEmpty())
            s.pop();
        assertNull(s.pop());
    }

    @Test
    void isEmpty() throws QueueExceptionOversize {
        Stack s = new Stack();
        assertTrue(s.isEmpty());
        s.push(1);
        assertFalse(s.isEmpty());
        s.pop();
        assertTrue(s.isEmpty());
    }
}