package sartakova;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayIteratorTest {
    @Test
    void nextTest() {
        Integer[][] array = new Integer[20][20];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j< array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 30);
            }
        }

        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(array);
        for (Integer[] subArray : array) {
            for (Integer i : subArray) {
                assertEquals(i, arrayIterator.next());
            }
        }
        assertFalse(arrayIterator.hasNext());
    }

    @Test
    void hasNextTest() {
        Integer[][] array = new Integer[20][20];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j< array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 30);
            }
        }

        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(array);
        for (Integer[] integer : array) {
            for (int j = 0; j < integer.length; j++) {
                assertTrue(arrayIterator.hasNext());
            }
        }
    }

    @Test
    void hasNextWithEmptyArrayTest() {
        String[][] array = new String[0][0];
        ArrayIterator<String> arrayIterator = new ArrayIterator<>(array);
        assertFalse(arrayIterator.hasNext());
    }

    @Test
    void hasNextWithEmptySubArrayTest() {
        Integer[][] array = {{}, {10}, {}};
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(array);
        assertTrue(arrayIterator.hasNext());
        arrayIterator.next();
        assertFalse(arrayIterator.hasNext());
    }

    @Test
    void nextWithEmptyArrayTest() {
        String[][] array = new String[0][0];
        ArrayIterator<String> arrayIterator = new ArrayIterator<>(array);
        assertThrows(NoSuchElementException.class, arrayIterator::next);
    }
}
