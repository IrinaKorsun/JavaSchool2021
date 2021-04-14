package pelipenko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    void throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Stack(-1));
        assertThrows(IllegalArgumentException.class, () -> new Stack(2000));
    }

    @Nested
    class NewWithoutArguments{
        Stack stackArray;
        String element = "element";

        @BeforeEach
        void setUp(){
            stackArray = new Stack();
        }

        @Test
        void isEmpty(){
            assertTrue(stackArray.isEmpty());
        }

        @Test
        void emptyPop() {
            assertNull(stackArray.pop());
        }

        @Test
        void emptyTop() {
            assertNull(stackArray.top());
        }

        @Test
        void throwsStackOverflowError() {
            assertThrows(Exception.class, () -> {
                for (int i = 0; i < 1001; i++) {
                    stackArray.push(element);
                }
            });
        }

        @Nested
        class AfterPushing {
            @BeforeEach
            void push() throws Exception {
                stackArray.push(element);
            }

            @Test
            void isNotEmpty() {
                assertFalse(stackArray.isEmpty());
            }

            @Test
            void pop() {
                assertEquals(element, stackArray.pop());
                assertTrue(stackArray.isEmpty());
            }

            @Test
            void top() {
                assertEquals(element, stackArray.top());
                assertFalse(stackArray.isEmpty());
            }
        }
    }
}
