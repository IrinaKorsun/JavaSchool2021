package bakunov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayIterator {
    private static ArrayIterator<Integer> arrayIterator;
    private static final int ARR_COL_SIZE = 10;
    private static final int ARR_ROW_SIZE = 3;
    private static Integer[][] items;

    @BeforeEach
    void setUp() {
        items = new Integer[ARR_COL_SIZE][ARR_ROW_SIZE];
        for (int i = 0; i < ARR_COL_SIZE; i++) {
            for (int j = 0; j < ARR_ROW_SIZE; j++) {
                items[i][j] = i * j;
            }
        }
        arrayIterator = new ArrayIterator<>(items);
    }

    @Test
    void getContent() {
        assertEquals(items, arrayIterator.getContent());
    }

    @Test
    void getSize() {
        assertEquals(ARR_COL_SIZE * ARR_ROW_SIZE, arrayIterator.getSize());
    }

    @Test
    void hasNext() {
        assertTrue(arrayIterator.hasNext());
        for (int i = 0; i < arrayIterator.getSize(); i++) {
            arrayIterator.next();
        }
        assertFalse(arrayIterator.hasNext());
    }

    @Test
    void next() {
        assertEquals(0, arrayIterator.next());
        for (int i = 0; i < ARR_ROW_SIZE * 3; i++) {
            arrayIterator.next();
        }
        assertEquals(3, arrayIterator.next());

    }

    @Test
    void nextIsEmpty() {
        Integer[][] emptyArray = {{}};
        ArrayIterator<Integer> emptyArrayIterator = new ArrayIterator<>(emptyArray);
        assertThrows(NoSuchElementException.class, emptyArrayIterator::next);
    }
}
