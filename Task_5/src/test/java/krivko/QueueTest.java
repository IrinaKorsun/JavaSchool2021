package krivko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Задание 5.1
 * <br> Тест очереди
 * @author krivko
 * @version 1.5
 * @see Queue
 * @since 02.04.2021
 */
class QueueTest {

    private Queue testQueue;

    @BeforeEach
    protected void setUp() {
        testQueue = new Queue();
    }

    @Test
    void enqueueNull() {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> testQueue.enqueue(null));
        assertNotNull(thrown.getMessage());
    }

    @Test
    void enqueueExceedsMaximum() {
        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            for (int i = 0; i < Queue.MAX_SIZE + 1; i++) {    // если убрать + 1, то тест уже не пройдет
                testQueue.enqueue(generatorObjects());
            }
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void enqueue() {
        for (int i = 0; i < 1000; i++) {
            testQueue.enqueue(generatorObjects());
        }
        assertEquals(1000, testQueue.getCount());
    }

    /**
     * Генерируем случаные данные, случайного типа
     * к примеру - символ, числа int и double, UUID, дату
     * @return возвращает случайные данные типа Object
     */
    private static Object generatorObjects() {
        Random random = new Random();
        switch (random.nextInt(5)) {
            case 0:
                return (char) (random.nextInt(26) + 'A');        // случайный символ
            case 1:
                return random.nextDouble();                             // случайное число double
            case 2:
                return UUID.randomUUID();                               // случайный индификатор (он же UUID, он же GUID)
            case 3:
                long ms = Math.abs(random.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000);   // случайная дата
                return new Date(ms);
            default:
                return random.nextInt();                                // случайное число int
        }
    }

    @Test
    void dequeue() {
        testQueue.enqueue(5);
        testQueue.dequeue();
        assertTrue(testQueue.isEmpty());
    }

    @Test
    void isEmptyFalse() {
        testQueue.enqueue(5);
        assertFalse(testQueue.isEmpty());
    }

    @Test
    void isEmptyTrue() {
        assertTrue(testQueue.isEmpty());
    }

    @Test
    void top() {
        testQueue.enqueue(5);
        assertEquals(5, testQueue.top());
    }

    @Test
    void topNull() {
        assertNull(testQueue.top());
    }

    @Test
    void getCount() {
        testQueue.enqueue(1);
        testQueue.enqueue(2);
        testQueue.enqueue(3);
        testQueue.enqueue(4);
        assertEquals(4, testQueue.getCount());
    }
}