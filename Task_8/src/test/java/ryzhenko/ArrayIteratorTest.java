package ryzhenko;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

public class ArrayIteratorTest {

    Integer[][] filledArray = {{5, 7, 3, 17}, {7, 0, 1, 12}, {8, 1, 2, 3}, {1, 2}};
    ArrayIterator<Integer> filledArrayIterator = new ArrayIterator<>(filledArray);
    Integer[][] emptyArray = new Integer[0][0];
    ArrayIterator<Integer> emptyArrayIterator = new ArrayIterator<>(emptyArray);

    @Test
    void testHasNext() {
        for (Integer[] integers : filledArray) {
            for (Integer integer : integers) {
                assertTrue(filledArrayIterator.hasNext());
                filledArrayIterator.next();
            }
        }
        assertFalse(filledArrayIterator.hasNext());
    }

    @Test
    void testHasNextIfArrayIsEmpty() {
        assertFalse(emptyArrayIterator.hasNext());
    }

    @Test
    void testNext() {
        for (Integer[] integers : filledArray) {
            for (Integer integer : integers) {
                assertSame(filledArrayIterator.next(), integer);
            }
        }
    }

    @Test
    void testNoSuchElementException() {
        for (Integer[] integers : filledArray) {
            for (Integer integer : integers) {
                assertTrue(filledArrayIterator.hasNext());
                filledArrayIterator.next();
            }
        }
        assertThrows(NoSuchElementException.class, () -> filledArrayIterator.next());
    }
}