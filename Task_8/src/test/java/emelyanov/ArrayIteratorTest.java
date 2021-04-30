package emelyanov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayIteratorTest {
    private Integer[][] array;
    private Integer[][] arrayNull;
    private ArrayIterator<Integer> iterator;

    @BeforeEach
    void setUp() {
        array = new Integer[][]{{5, 7, 3, 17}, {7, 0, 1, 12}, {8, 1, 2, 3}, {1, 2}};
        arrayNull = new Integer[][]{{}, {}, {}, {}};

    }

    @Test
    void checkItems() {
        iterator = new ArrayIterator<>(array);
        while (iterator.hasNext()) {
            for (Integer[] integers : array) {
                for (Integer integer : integers) assertEquals(iterator.next(), integer);
            }
        }
    }

    @Test
    void hasNext() {
        iterator = new ArrayIterator<>(array);
        assertTrue(iterator.hasNext());
    }

    @Test
    void hasNextIsEmpty() {
        iterator = new ArrayIterator<>(arrayNull);
        assertFalse(iterator.hasNext());
    }

    @Test
    void checkThrowsNoSuchElementException() {
        iterator = new ArrayIterator<>(arrayNull);
        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }
}
