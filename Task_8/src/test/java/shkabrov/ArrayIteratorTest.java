package shkabrov;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayIteratorTest {
    public static int calculateRandomNumber(int minValue, int maxValue) {
        return minValue + (int) (Math.random() * maxValue); // правая граница не включена в диапазон
    }

    @Test
    public void hasNext() {
        Integer[][] testArray = new Integer[5][5];
        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray[i].length; j++) {
                testArray[i][j] = calculateRandomNumber(0, 11);
            }
        }
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(testArray);
        for (Integer[] currentRow : testArray) {
            for (Integer currentColumn : currentRow) {
                assertTrue(arrayIterator.hasNext());
                arrayIterator.next();
            }
        }
        assertFalse(arrayIterator.hasNext());
    }

    @Test
    public void next() {
        Integer[][] testArray = new Integer[][]{{1}, {2}, {3}};
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(testArray);
        Integer[] extractedValues = new Integer[3];
        int i = 0;
        while (arrayIterator.hasNext()) {
            extractedValues[i] = arrayIterator.next();
            i++;
        }
        assertArrayEquals(new Integer[]{1, 2, 3}, extractedValues);
    }

    @Test
    public void workWithEmptyArrays() {
        Integer[][] sourceArray = {{}, {1, 2, 3}, {}, {4, 5}, {}, {}, {6, 7}, {}, {}};
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(sourceArray);
        List<Integer> extractedValues = new ArrayList<>();
        while (arrayIterator.hasNext()) {
            extractedValues.add(arrayIterator.next());
            if (extractedValues.size() == 7) {
                assertFalse(arrayIterator.hasNext());
            }
        }
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7}, extractedValues.toArray(new Integer[0]));

        Integer[][] emptySourceArray = {};
        arrayIterator = new ArrayIterator<>(emptySourceArray);
        assertFalse(arrayIterator.hasNext());
        assertThrows(NoSuchElementException.class, () -> {
            Integer[][] emptySourceArray2 = {{}};
            ArrayIterator<Integer> arrayIterator2 = new ArrayIterator<>(emptySourceArray2);
            arrayIterator2.next();
        });

        Integer[][] nullSourceArray = new Integer[5][5];
        arrayIterator = new ArrayIterator<>(nullSourceArray);
        for (Integer[] currentRow : nullSourceArray) {
            for (Integer currentColumn : currentRow) {
                assertTrue(arrayIterator.hasNext());
                arrayIterator.next();
            }
        }
        assertFalse(arrayIterator.hasNext());
    }
}
