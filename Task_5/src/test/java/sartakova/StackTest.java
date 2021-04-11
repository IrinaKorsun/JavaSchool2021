package sartakova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {
    @Test
    public void testPush() throws Exception {
        Stack stack = new Stack(10);
        for (int i = 1; i < 10; i++) {
            stack.push(i);
        }
        assertFalse(stack.isEmpty());
        assertEquals(9, stack.top());
    }

    @Test
    public void testPop() throws Exception {
        Stack stack = new Stack(10);
        for (int i = 1; i < 10; i++) {
            stack.push(i);
        }
        assertEquals(9, stack.pop());
        assertEquals(8, stack.getCurrentNumber());
    }

    @Test
    public void testPopInEmptyStack() {
        Stack stack = new Stack(3);
        Assertions.assertThrows(Exception.class, () -> stack.pop());
    }

    @Test
    public void testTopInEmptyStack() {
        Stack stack = new Stack(10);
        Assertions.assertThrows(Exception.class, stack::top);
    }

    @Test
    public void testIsEmpty() {
        Stack stack = new Stack(55);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testTop() throws Exception {
        Stack stack = new Stack(5);
        for (char i = 'a'; i <= 'd'; i++) {
            stack.push(i);
        }
        assertEquals('d', stack.top());
        assertEquals(4, stack.getCurrentNumber());
    }


    @Test
    public void testPushInFullStack() throws Exception {
        Stack stack = new Stack(5);
        for (char i = 'a'; i <= 'e'; i++) {
            stack.push(i);
        }
        Assertions.assertThrows(Exception.class, () -> stack.push('f'));
    }
}