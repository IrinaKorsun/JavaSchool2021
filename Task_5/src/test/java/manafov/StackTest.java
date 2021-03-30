package manafov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    void throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Stack(-1));
        assertThrows(IllegalArgumentException.class, () -> new Stack(1001));
    }

    @Nested
    class NewWithoutArguments {
        Stack stack;
        String element = "element";

        @BeforeEach
        void setUp() {
            stack = new Stack();
        }

        @Test
        void isEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test
        void emptyPop() {
            assertNull(stack.pop());
        }

        @Test
        void emptyTop() {
            assertNull(stack.top());
        }

        @Test
        void throwsStackOverflowError() {
            assertThrows(StackOverflowError.class, () -> {
                for (int i = 0; i < 1001; i++) {
                    stack.push(element);
                }
            });
        }

        @Nested
        class AfterPushing {
            @BeforeEach
            void push() {
                stack.push(element);
            }

            @Test
            void isNotEmpty() {
                assertFalse(stack.isEmpty());
            }

            @Test
            void pop() {
                assertEquals(element, stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            void top() {
                assertEquals(element, stack.top());
                assertFalse(stack.isEmpty());
            }
        }
    }
}
