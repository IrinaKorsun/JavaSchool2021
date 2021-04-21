package mozzherin;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIteratorTest {

    @Test
    void arrayIteratorTestNextHasNext() {
        final int SIZE_ARRAY = 10;

        Integer[][] randomArray = new Integer[SIZE_ARRAY][SIZE_ARRAY];
        for (int i = 0; i < SIZE_ARRAY; i++) {
            for (int j = 0; j < SIZE_ARRAY; j++) {
                randomArray[i][j] = ((int)(Math.random() * 10));
            }
        }

        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(randomArray);
        if (arrayIterator.iterator().hasNext()) {
            for (Integer[] item : randomArray) {
                for (Integer elem : item) {
                    assertEquals(arrayIterator.iterator().next(), elem);
                }
            }
        }
        assertFalse(arrayIterator.iterator().hasNext());
    }

    @Test
    void emptyArrayIterator() {
        Integer[][] emtyArray = {{}};
        ArrayIterator<Integer> emptyArrayIterator = new ArrayIterator<>(emtyArray);
        assertThrows(NoSuchElementException.class, () -> emptyArrayIterator.iterator().next());
    }

}