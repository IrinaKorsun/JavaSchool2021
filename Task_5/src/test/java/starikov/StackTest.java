package starikov;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack stack = new Stack(5);

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty());

        stack.push(null);
        assertTrue(stack.isEmpty());

        stack.push(25);
        assertFalse(stack.isEmpty());

        stack.top();
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void push() {
        stack.push(25);
        stack.push(32);
        stack.push(41);

        assertEquals(2, stack.getIndex());
        Object[] expectedArray = {25, 32, 41, null, null};
        assertArrayEquals(expectedArray, stack.getStack());

        stack.push(54);
        stack.push(69);
        assertThrows(StackAndQueueException.class, () -> stack.push(77));
    }

    @Test
    void top() {
        stack.push(25);
        stack.push(32);
        stack.push(41);

        assertEquals(2, stack.getIndex());
        assertEquals(41, stack.top());

        Object[] expectedArray = {25, 32, 41, null, null};
        assertArrayEquals(expectedArray, stack.getStack());

        stack.pop();
        stack.pop();
        stack.pop();
        assertThrows(StackAndQueueException.class, () -> stack.top());
    }

    @Test
    void pop() {
        stack.push(25);
        stack.push(32);
        stack.push(41);

        assertEquals(41, stack.pop());
        assertEquals(1, stack.getIndex());
        Object[] expectedArray = {25, 32, null, null, null};
        assertArrayEquals(expectedArray, stack.getStack());

        assertEquals(32, stack.pop());
        assertEquals(0, stack.getIndex());
        Object[] expectedArray2 = {25, null, null, null, null};
        assertArrayEquals(expectedArray2, stack.getStack());

        stack.pop();
        assertThrows(StackAndQueueException.class, () -> stack.pop());
    }

    @Test
    void manyTimesPushAndPop() {
        boolean flag = false;

        for (int i = 0; i < 1000000; i++) {

            if (i % stack.getStack().length == 0) {
                flag = !flag;
            }

            if (flag) {
                stack.push(i);
            } else {
                stack.pop();
            }

            if (i < 100) {
                System.out.println(Arrays.toString(stack.getStack()));
            }
        }
    }
}