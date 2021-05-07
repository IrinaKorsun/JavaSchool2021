package podolyak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIteratorTest {

    private ArrayIterator arrayIteratorFull;
    private ArrayIterator arrayIteratorEmpty;
    private Object[][] testArray = {{5, 7, 3, 17}, {7, 0, 1, 12}, {8, 1, 2, 3}, {1, 2}};

    @BeforeEach
    public void createFullArray() {
        arrayIteratorFull = new ArrayIterator(testArray);
    }

    @BeforeEach
    public void createEmptyArray() {
        Object[][] emptyArray = {};
        arrayIteratorEmpty = new ArrayIterator(emptyArray);
    }

    @Test
    void hasNextFull() {
        assertTrue(arrayIteratorFull.hasNext());
    }

    @Test
    void hasNextEmpty() {
        assertFalse(arrayIteratorEmpty.hasNext());
    }

    @Test
    void nextException() {
        assertThrows(Exception.class, () -> {
            arrayIteratorEmpty.next();
        });
    }

    @Test
    void next() {
        for (Object[] array : testArray) {
            for (Object item : array) {
                assertEquals(item, arrayIteratorFull.next());
            }
        }
    }
}