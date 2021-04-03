package manafov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test
    void throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Queue(-1));
        assertThrows(IllegalArgumentException.class, () -> new Queue(1001));
    }

    @Nested
    class NewWithoutArguments {
        Queue queue;
        String element1 = "element1";
        String element2 = "element2";

        @BeforeEach
        void setUp() {
            queue = new Queue();
        }

        @Test
        void isEmpty() {
            assertTrue(queue.isEmpty());
        }

        @Test
        void emptyDequeue() {
            assertNull(queue.dequeue());
        }

        @Test
        void emptyTop() {
            assertNull(queue.top());
        }

        @Test
        void throwsIllegalStateException() {
            assertThrows(IllegalStateException.class, () -> {
                for (int i = 0; i < 1001; i++) {
                    queue.enqueue(element1);
                }
            });
        }

        @Nested
        class AfterEnqueue {
            @BeforeEach
            void enqueue() {
                queue.enqueue(element1);
                queue.enqueue(element2);
            }

            @Test
            void isNotEmpty() {
                assertFalse(queue.isEmpty());
            }

            @Test
            void dequeue() {
                assertEquals(element1, queue.dequeue());
                assertEquals(element2, queue.dequeue());
                assertTrue(queue.isEmpty());
            }

            @Test
            void top() {
                assertEquals(element1, queue.top());
                assertEquals(element1, queue.top());
                assertFalse(queue.isEmpty());
            }
        }
    }
}
