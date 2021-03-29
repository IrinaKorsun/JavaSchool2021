package krivko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Задание 5.2
 * <br> Тест стека
 * @author krivko
 * @version 1.5
 * @see Stack
 * @since 02.04.2021
 */
class StackTest {

    private Stack testStack;

    @BeforeEach
    void setUp() {
        testStack = new Stack();
    }

    @Test
    void pushNull() {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> testStack.push(null));
        assertNotNull(thrown.getMessage());
    }

    @Test
    void pushExceedsMaximum() {
        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            for (int i = 0; i < Stack.MAX_SIZE + 1; i++) {  // если убрать + 1, то тест уже не пройдет
                testStack.push(generatorObjects());
            }
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void push() {
        for (int i = 0; i < 1000; i++) {
            testStack.push(generatorObjects());
        }
        assertEquals(1000, testStack.getCount());
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
    void pop() {
        testStack.push(5);
        assertEquals(5, testStack.pop());
    }

    @Test
    void popNull() {
        assertNull(testStack.pop());
    }

    @Test
    void isEmptyFalse() {
        testStack.push(5);
        assertFalse(testStack.isEmpty());
    }

    @Test
    void isEmptyTrue() {
        assertTrue(testStack.isEmpty());
    }

    @Test
    void top() {
        testStack.push(5);
        assertEquals(5, testStack.top());
    }

    @Test
    void topNull() {
        assertNull(testStack.top());
    }

    @Test
    void getCount() {
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(4);
        assertEquals(4, testStack.getCount());
    }
}