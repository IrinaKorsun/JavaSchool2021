package starikov;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIteratorTest {

    String[][] emptyArr = {{}, {}, {}};
    Integer[][] arrWithEmpty = {{}, {1, 2, 3}, {3, 4}};
    Integer[][] array = {{5, 7, 3, 17}, {7, 0, 1, 12}, {8, 1, 2, 3}, {1, 2}};

    ArrayIterator<String> emptyArrIter = new ArrayIterator<>(emptyArr);
    ArrayIterator<Integer> arrWithEmptyIter = new ArrayIterator<>(arrWithEmpty);
    ArrayIterator<Integer> arrayIter = new ArrayIterator<>(array);

    @Test
    void hasNext() {

        //emptyArr
        assertFalse(emptyArrIter.hasNext());

        //arrWithEmpty
        assertTrue(arrWithEmptyIter.hasNext());
        for (int i = 0; i < 5; i++) {
            arrWithEmptyIter.next();
        }
        assertFalse(emptyArrIter.hasNext());

        //arrayIter
        assertTrue(arrayIter.hasNext());
        for (int i = 0; i < 14; i++) {
            arrayIter.next();
        }
        assertFalse(arrayIter.hasNext());
    }

    @Test
    void next() {

        //emptyArrIter
        assertThrows(NoSuchElementException.class, () -> emptyArrIter.next());

        //arrWithEmpty
        for (Integer[] arr : arrWithEmpty
        ) {
            for (Integer elem : arr
            ) {
                assertEquals(elem, arrWithEmptyIter.next());
            }

        }
        assertThrows(NoSuchElementException.class, () -> arrWithEmptyIter.next());

        //arrayIter
        for (Integer[] arr : array
        ) {
            for (Integer elem : arr
            ) {
                assertEquals(elem, arrayIter.next());
            }

        }
        assertThrows(NoSuchElementException.class, () -> arrayIter.next());
    }
}