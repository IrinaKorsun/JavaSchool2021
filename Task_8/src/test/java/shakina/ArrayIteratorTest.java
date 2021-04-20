package shakina;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIteratorTest {

    @Test
    void hasNextTest() {
        Integer[][] array = new Integer[15][15];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j< array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 50);
            }
        }

        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(array);
        for (Integer[] integers : array) {
            for (int j = 0; j < integers.length; j++) {
                assertTrue(arrayIterator.hasNext());
            }
        }
    }

    @Test
    void nextTest() {
        Integer[][] array = new Integer[15][15];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j< array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 50);
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
    void hasNextWithEmptyArrayTest() {
        String[][] array = new String[0][0];
        ArrayIterator<String> arrayIterator = new ArrayIterator<>(array);
        assertFalse(arrayIterator.hasNext());
    }

    @Test
    void hasNextWithEmptySubArrayTest() {
        Integer[][] array = {{}, {5}, {}};
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