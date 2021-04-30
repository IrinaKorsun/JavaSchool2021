package galuza;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class TestArrayIterator <T> {
    private String[][] strings = new String[][]{
            {"a00", "a01"},
            {"a10", "a11", "a12"},
            {"a20"}
    };

    @Test
    void testHasNextAndNext() {
        ArrayIterator<String> arrayIterator = new ArrayIterator<>(strings);
        assertAll(
                () -> assertTrue(arrayIterator.hasNext()),
                () -> assertEquals("a00", arrayIterator.next()),
                () -> assertTrue(arrayIterator.hasNext()),
                () -> assertEquals("a01", arrayIterator.next()),
                () -> assertTrue(arrayIterator.hasNext()),
                () -> assertEquals("a10", arrayIterator.next()),
                () -> assertTrue(arrayIterator.hasNext()),
                () -> assertEquals("a11", arrayIterator.next()),
                () -> assertTrue(arrayIterator.hasNext()),
                () -> assertEquals("a12", arrayIterator.next()),
                () -> assertTrue(arrayIterator.hasNext()),
                () -> assertEquals("a20", arrayIterator.next()),
                () -> assertFalse(arrayIterator.hasNext()),
                () -> assertThrows(NoSuchElementException.class, () -> arrayIterator.next())
        );
    }

    @Test
    void TestIterationArray() {
        ArrayIterator<String> arrayIterator1 = new ArrayIterator<>(strings);
        while (arrayIterator1.hasNext()) {
            assertTrue(arrayIterator1.next() instanceof String);
        }
    }
}
