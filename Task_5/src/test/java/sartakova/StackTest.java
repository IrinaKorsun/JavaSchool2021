package sartakova;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest  {
    @Test
    public void testPush() throws Exception {
        Stack stack = new Stack(10);
        stack.push('1');
        stack.push('2');
        stack.push('3');
        stack.push('4');
        stack.push('5');
        stack.push('6');
        stack.push('7');
        stack.push('8');
        stack.push('9');
        assertFalse(stack.isEmpty());
        assertEquals('9', stack.top());
    }

    @Test
    public void testPop() throws Exception {
        Stack stack = new Stack(5);
        stack.push(2);
        stack.push(3);
        stack.push(3);
        stack.push(6);
        stack.push(8);
        assertEquals(8, stack.pop());
        assertEquals(4, stack.getCurrentNumber());
    }

    @Test
    public void testPopInEmptyStack() {
        Stack stack = new Stack(3);
        Assertions.assertThrows(Exception.class,() ->  stack.pop());
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
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');
        assertEquals('d', stack.top());
        assertEquals(4, stack.getCurrentNumber());
    }

    @Test
    public void testPushInFullStack() throws Exception {
        Stack stack = new Stack(4);
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');
        Assertions.assertThrows(Exception.class, () -> stack.push('k'));
    }
   }