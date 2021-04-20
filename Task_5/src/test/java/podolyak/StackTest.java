package podolyak;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private final int MAX_SIZE = 10_000;
    private Stack fullStack;
    private Stack emptyStack;

    @BeforeEach
    void createFullStack() {
        fullStack = new Stack(MAX_SIZE);
        for (int i = 0; i < MAX_SIZE; i++) {
            try {
                fullStack.push(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @BeforeEach
    void createEmptyStack() {
        emptyStack = new Stack(MAX_SIZE);
    }

    @Test
    void testPush() throws Exception {
        Assertions.assertEquals(fullStack.top(), MAX_SIZE-1);
    }

    @Test
    void testExceptionPush() {
        Object object = 10;
        assertThrows(Exception.class, () -> {
            fullStack.push(object);
        });
    }


    @Test
    void testPop() throws Exception {
        Assertions.assertEquals(fullStack.pop(), MAX_SIZE-1);
    }


    @Test
    void testExceptionPop() {
        assertThrows(Exception.class, () -> {
            emptyStack.pop();
        });
    }

    @Test
    void testTop() throws Exception {
        Assertions.assertEquals(fullStack.top(), MAX_SIZE-1);
    }

    @Test
    void testExceptionTop() {
        assertThrows(Exception.class, () -> {
            emptyStack.top();
        });
    }
}