package krivko;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIteratorTest {

    @Test
    void hasNext() {
        Integer[][] array = {{1}};
        var arrayIterator = new ArrayIterator<>(array);
        assertTrue(arrayIterator.hasNext());
        arrayIterator.next();
        assertFalse(arrayIterator.hasNext());
    }

    @Test
    void next() {
        Random random = new Random();
        Integer[][] array = new Integer[10][10];
        for (int j = 0; j < array.length; j++) {
            for (int k = 0; k < array.length; k++) {
                array[j][k] = random.nextInt(10);
            }
        }

        var arrayIterator = new ArrayIterator<>(array);
        for (Integer[] integers : array) {
            for (Integer integer : integers) {
                assertEquals(integer, arrayIterator.next());
            }
        }
    }

    @Test
    void nextThrowsNoSuchElementException() {
        Integer[][] array = {{}};
        var arrayIterator = new ArrayIterator<>(array);
        assertThrows(NoSuchElementException.class, arrayIterator::next);
    }
}