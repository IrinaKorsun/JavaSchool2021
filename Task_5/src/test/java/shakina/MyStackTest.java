package shakina;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shakina.exception.MyException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    public void testPush() throws MyException {
        MyStack stack = new MyStack(5);
        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.push('D');
        assertFalse(stack.isEmpty());
        assertEquals('D', stack.top());
    }

    @Test
    public void testPop() throws MyException {
        MyStack stack = new MyStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(2, stack.getCurrentSize());
    }

    @Test
    public void testIsEmpty() {
        MyStack stack = new MyStack(100);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testTop() throws MyException {
        MyStack stack = new MyStack(6);
        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.push('D');
        assertEquals('D', stack.top());
        assertEquals(4, stack.getCurrentSize());
    }

    @Test
    public void testPushInFullStack() throws MyException {
        MyStack stack = new MyStack(4);
        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.push('D');
        Assertions.assertThrows(MyException.class, () -> stack.push('E'));
    }

    @Test
    public void testPopInEmptyStack() {
        MyStack stack = new MyStack(3);
        Assertions.assertThrows(MyException.class, stack::pop);
    }

    @Test
    public void testTopInEmptyStack() {
        MyStack stack = new MyStack(10);
        Assertions.assertThrows(MyException.class, stack::top);
    }
}