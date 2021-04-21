package zhmaylo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class ArrayIteratorTest {
    private static final int randomInt = (int) (Math.random() * 4);
    private static final Integer[][] matrix = new Integer[randomInt][randomInt];

    @BeforeAll
    static void beforeAll() {
        for (int i = 0; i < randomInt; i++) {
            for (int j = 0; j < randomInt; j++) {
                matrix[i][j] = (int) (Math.random() * randomInt);
            }
        }
    }

    @Test
    void next() {
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(matrix);
        for (Integer[] i : matrix) {
            for (Integer j : i) {
                Assertions.assertEquals(j, arrayIterator.next());
            }
        }
        try {
            arrayIterator.next();
        } catch (NoSuchElementException e) {
            Assertions.assertEquals(e.getMessage(), "No more elements!");
        }
    }

    @Test
    void nextErrorEmptyMatrix() {
        Integer[][] matrix = {{}, {}};
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(matrix);
        try {
            arrayIterator.next();
        } catch (NoSuchElementException e) {
            Assertions.assertEquals(e.getMessage(), "No more elements!");
        }
    }

    @Test
    void hasNext() {
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(matrix);
        for (int i = 0; i < randomInt; i++) {
            for (int j = 0; j < randomInt; j++) {
                arrayIterator.next();
                if ((i == randomInt - 1) && (j == randomInt - 1)) {
                    Assertions.assertFalse(arrayIterator.hasNext());
                } else {
                    Assertions.assertTrue(arrayIterator.hasNext());
                }
            }
        }
    }
}
