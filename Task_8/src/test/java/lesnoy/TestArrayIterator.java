package lesnoy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayIterator {
    private static final int COL_COUNT = 5;
    private static final int ROW_COUNT = 7;
    private static Integer[][] items;
    private static ArrayIterator<Integer> arrayIterator;

    @BeforeEach
    void setUp() {
        items = new Integer[COL_COUNT][ROW_COUNT];
        for (int i = 0; i < COL_COUNT; i++) {
            for (int j = 0; j < ROW_COUNT; j++) {
                items[i][j] = (int) (Math.random() * 1000);
            }
        }
        items[0][0] = 5;
        arrayIterator = new ArrayIterator<>(items);
    }

    @Test
    void hasNext() {
        assertEquals(true, arrayIterator.hasNext());
        for (int i = 0; i < COL_COUNT * ROW_COUNT; i++) {
            arrayIterator.next();
        }
        assertFalse(arrayIterator.hasNext());
    }

    @Test
    void next() {
        assertEquals(5, arrayIterator.next());
    }

    @Test
    void nextIsEmpty() {
        Integer[][] emptyArray = {{}};
        ArrayIterator<Integer> emptyArrayIterator = new ArrayIterator<>(emptyArray);
        assertThrows(NoSuchElementException.class, emptyArrayIterator::next);
    }
}
