package khoroshev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayIteratorTest {
    private ArrayIterator<Integer> arrayIterator;
    private List<Integer> elements;

    @BeforeEach
    void setUp() {
        Integer[][] mass = new Integer[][]{{5, 7, 3, 17}, {7, 0, 1, 12}, {8, 1, 2, 3}, {1, 2}};
        arrayIterator = new ArrayIterator<>(mass);
        elements = new LinkedList<>();
        for (Integer[] integers : mass) {
            elements.addAll(Arrays.asList(integers));
        }
    }

    @Test
    void nextTest() {
        int i = 0;
        while (arrayIterator.hasNext()) {
           assertEquals(elements.get(i),  arrayIterator.next());
           i++;
       }
    }

    @Test
    void nextThrowExceptionTest() {
        int i = 0;
        while (arrayIterator.hasNext()) {
            assertEquals(elements.get(i),  arrayIterator.next());
            i++;
        }
        assertThrows(NoSuchElementException.class, arrayIterator::next);
    }

    @Test
    void hasNextTest() {
        int count = 0;
        while (arrayIterator.hasNext()) {
            arrayIterator.next();
            count++;
        }
        assertEquals(elements.size(), count);
    }

    @Test
    void hasNextEmptyArrayTest() {
        arrayIterator = new ArrayIterator<>(new Integer[0][0]);
        assertFalse(arrayIterator.hasNext());
    }
}
