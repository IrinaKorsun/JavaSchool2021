package pelipenko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayIteratorTest {
    Integer[][] array;
    ArrayIterator<Integer> iterator;

    @BeforeEach
    void setUp() {
        array = new Integer[10][10];
        for (int j = 0; j < array.length; j++) {
            for (int k = 0; k < array.length; k++) {
                array[j][k] = (int) (Math.random() * 100);
            }
        }
        iterator = new ArrayIterator<>(array);
    }

    @Test
    void nextThrowsNoSuchElements() {
        Integer[][] array = {{}};
        iterator = new ArrayIterator<>(array);
        assertThrows(NoSuchElementException.class, () -> iterator.next());
        System.out.println("Пусто!!!1!!!");
    }

    @Test
    void hasNext() {
        for (Integer[] items : array) {
            for (Integer item : items) {
                assertTrue(iterator.hasNext());
                iterator.hasNext();
            }
        }
    }

    @Test
    void next() {
        for (Integer[] items : array) {
            for (Integer item : items) {
                assertEquals(item, iterator.next());
            }
        }
    }
}
