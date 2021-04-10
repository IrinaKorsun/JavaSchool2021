package galuza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestArtisanalQueue {

    @Test
    void testArtisanalQueueIsEmpty() {
        ArtisanalQueue queue = new ArtisanalQueue();

        assertEquals(true, queue.isEmpty());
    }

    @Test
    void testArtisanalNotQueueIsEmpty() {
        ArtisanalQueue queue = new ArtisanalQueue();
        queue.enQueue("1");
        queue.enQueue("2");
        queue.enQueue("3");

        assertEquals(false, queue.isEmpty());
    }

    @Test
    void testArtisanalQueueCapacity() {
        ArtisanalQueue queue = new ArtisanalQueue();

        assertEquals(1000, queue.getCapacity());
    }

    @Test
    void testArtisanalQueueCount() {
        ArtisanalQueue queue = new ArtisanalQueue();
        queue.enQueue("first");
        queue.enQueue("second");
        queue.enQueue("third");
        queue.enQueue("fourth");

        assertEquals(4, queue.getCount());
    }

    @Test
    void testArtisanalQueueIsEmptyException() {
        ArtisanalQueue queue = new ArtisanalQueue();

        assertThrows(ArtisanalException.class, () -> queue.deQueue());
    }

    @Test
    void testArtisanalQueueOverCapacity() {
        ArtisanalQueue queue = new ArtisanalQueue();
        for (int i = 0; i < 1500; i++) {
            queue.enQueue(i);
        }
        assertEquals(1500, queue.getCapacity());
    }

    @Test
    void testDeQueue() throws ArtisanalException {
        ArtisanalQueue queue = new ArtisanalQueue();
        queue.enQueue("first");
        queue.enQueue("second");
        queue.enQueue("third");
        queue.enQueue("fourth");
        queue.deQueue();

        assertAll(
                () -> assertEquals(3, queue.getCount()),
                () -> assertEquals("second", queue.top())
        );
    }

    @Test
    void testArtisanalDeQueueIsEmptyException() throws ArtisanalException {
        ArtisanalQueue queue = new ArtisanalQueue();
        queue.enQueue("first");
        queue.enQueue("second");
        queue.enQueue("third");
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();

        assertThrows(ArtisanalException.class, () -> queue.deQueue());
    }
}
