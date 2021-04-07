package zhmaylo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


class StackTest {

    private static String testObject = "Simple test string";
    private static String testObject1 = "Simple test string1";
    private static final int LOOP_RANGE = 100000;


    @Test
    void whatIfMillionsPush() throws IndexOutOfReserved {
        Stack stack = new Stack(5);
        for (int i = 0; i < 1000000; i++) {
            testObject = String.valueOf(i); //сделаем миллион обьектов а не миллион ссылок на один если я ничего не перепутал
            stack.push(testObject);
            if (i % LOOP_RANGE == 0) {
                System.out.println("Push func " + stack);
            }
        }
    }


    @Test
    void isEmptyCorrectBoolReturn() throws IndexOutOfReserved {
        Stack stack = new Stack(5);
        Assertions.assertTrue(stack.isEmpty());

        stack.push(testObject);
        Assertions.assertFalse(stack.isEmpty());
    }


    @Test
    void checkCorrectDeleteElements() throws IndexOutOfReserved {
        Stack stack = new Stack(5);
        Assertions.assertNull(stack.pop());
        stack.push(testObject);
        stack.push(testObject1);
        Assertions.assertEquals(testObject1, stack.pop());
        Assertions.assertEquals(testObject, stack.top());
    }


    @Test
    void crashIfWrongTopReturn() throws IndexOutOfReserved {
        Stack stack = new Stack(5);
        Assertions.assertNull(stack.top());

        stack.push(testObject);
        Assertions.assertEquals(testObject, stack.top());
    }


    @Test
    void checkStackOverSized() {
        Stack stack = new Stack(5);
        try {
            for (int i = 0; i < 2000001; i++) {
                stack.push(testObject);
            }
        } catch (IndexOutOfReserved e) {
            Assertions.assertEquals(e.getMessage(), "Stack is oversize!");
        }
    }
}
