package komissarov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIteratorTest {
    private Integer[][] array;
    private Integer[][] arrayNull;
    private ArrayIterator<Integer> arrayIterator;

    @BeforeEach
    void setUp() {
        array = new Integer[][]{{1}, {2, 3, 4, 5,}, {6, 7}, {8, 9, 10, 11, 12,}};
        arrayNull = new Integer[][]{{}, {}, {}, {}};

    }
    @Test
    void TestIterator() {
        arrayIterator = new ArrayIterator<>(array);
        Iterator<Integer> iterator = arrayIterator.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
    @Test
    void hasNext() {
        arrayIterator = new ArrayIterator<>(array);
        Iterator<Integer> iterator = arrayIterator.iterator();
        assertTrue(iterator.hasNext());
    }
    @Test
    void hasNextIsEmpty() {
        arrayIterator = new ArrayIterator<>(arrayNull);
        Iterator<Integer> iterator = arrayIterator.iterator();
        assertFalse(iterator.hasNext());
    }

}