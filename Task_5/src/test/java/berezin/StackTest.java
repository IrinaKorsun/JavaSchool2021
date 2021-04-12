package berezin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void stackPushTopAndPopTest() throws QueueStackException {
        Stack stack = new Stack(3);
        Object obj1 = 1;
        Object obj2 = 2;
        Object obj3 = 3;
        stack.push(obj1);
        stack.push(obj2);
        stack.push(obj3);
        assertEquals(obj3, stack.pop());
        assertEquals(obj2, stack.top());
        assertEquals(obj2, stack.top());
    }


    @Test
    public void stackPushErrorTest() {
        Stack stack = new Stack(2);
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
        }catch (QueueStackException e){
            assertEquals(ErrorCode.STACK_IS_FULL, e.getErrorCode());
        }

    }

    @Test
    public void stackPopErrorTest(){
        Stack stack = new Stack(5);
        try{
            stack.pop();
        }catch (QueueStackException e){
            assertEquals(ErrorCode.STACK_IS_EMPTY, e.getErrorCode());
        }
    }

    @Test
    public void stackIsEmptyTest() throws QueueStackException {
        Stack stack = new Stack(3);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void stackIsEmptyPopTest() throws QueueStackException {
        Stack stack = new Stack(3);
        stack.push(1);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void stackNotEmptyTest() throws QueueStackException {
        Stack stack = new Stack(3);
        stack.push(22);
        assertFalse(stack.isEmpty());
    }
}
