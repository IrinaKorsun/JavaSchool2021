package zatsepin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIteratorTest {
    private static final int ARRAY_SIZE = 5;
    private ThreadLocalRandom rand = ThreadLocalRandom.current();
    private ArrayIterator<Integer> iterator = null;
    private Integer[][] input = null;
    private List<Integer> output = null;

    @BeforeEach
    void setUp() {
        input = new Integer[ARRAY_SIZE][ARRAY_SIZE];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                input[i][j] = rand.nextInt();
            }
        }
        iterator = new ArrayIterator<>(input);
        output = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        iterator = null;
        output = null;
    }

    @Test
    void testIterator() {
        while (iterator.hasNext()) {
            output.add(iterator.next());
        }
        assertEquals(ARRAY_SIZE * ARRAY_SIZE, output.size());
    }

    @Test
    void testHasNextFalseAndNextThrowsException() {
        while (iterator.hasNext()) {
            output.add(iterator.next());
        }
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testIteratorIfArrayIsEmpty() {
        iterator = new ArrayIterator<>(new Integer[0][0]);
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testNextReturnMatchValue() {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                assertEquals(input[i][j], iterator.next());
            }
        }
    }
}