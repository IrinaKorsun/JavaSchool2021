package manafov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIteratorTest {
    Integer[][] array;
    ArrayIterator<Integer> i;

    @BeforeEach
    void setUp() {
        array = new Integer[10][10];
        for (int j = 0; j < array.length; j++) {
            for (int k = 0; k < array.length; k++) {
                array[j][k] = (int) (Math.random() * 50);
            }
        }
        i = new ArrayIterator<>(array);
    }

    @Test
    void hasNext() {
        for (Integer[] items : array) {
            for (Integer item : items) {
                assertTrue(i.hasNext());
                i.next();
            }
        }
        assertFalse(i.hasNext());
    }

    @Test
    void nextThrowsNoSuchElementException() {
        Integer[][] emptyArray = {{}};
        i = new ArrayIterator<>(emptyArray);
        assertThrows(NoSuchElementException.class, () -> i.next());
    }

    @Test
    void next() {
        for (Integer[] items : array) {
            for (Integer item : items) {
                assertEquals(item, i.next());
            }
        }
    }
}
