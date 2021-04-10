package galuza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestArtisanalStack {

    @Test
    void testStackPush() {
        ArtisanalStack stack = new ArtisanalStack();
        try {
            stack.push("one");
            stack.push("two");
            stack.push("three");
        } catch (ArtisanalException e) {
            System.out.println(e);
        }

        assertAll(
                () -> assertEquals("one", stack.getElements()[0]),
                () -> assertEquals("two", stack.getElements()[1]),
                () -> assertEquals("three", stack.getElements()[2]),
                () -> assertEquals(null, stack.getElements()[3])
        );
    }

    @Test
    void testStackIsEmpty() {
        ArtisanalStack stack = new ArtisanalStack();

        assertEquals(true, stack.isEmpty());
    }

    @Test
    void testStackTop() {
        ArtisanalStack stack = new ArtisanalStack();
        try {
            stack.push("one");
            stack.push("two");
            stack.push("three");
            stack.push("four");
        } catch (ArtisanalException e) {
            e.printStackTrace();
        }
        assertAll(
                () -> assertEquals("four", stack.top()),
                () -> assertEquals(4, stack.getCount())
        );
    }

    @Test
    void testStackPop() {
        ArtisanalStack stack = new ArtisanalStack();
        try {
            stack.push("one");
            stack.push("two");
            stack.push("three");
            stack.push("four");
        } catch (ArtisanalException e) {
            e.printStackTrace();
        }
        assertAll(
                () -> assertEquals("four", stack.pop()),
                () -> assertEquals(3, stack.getCount())
        );
    }

    @Test
    void testStackExceptionStackIsEmpty() {
        ArtisanalStack stack = new ArtisanalStack();
        try {
            stack.top();
        } catch (ArtisanalException e) {
            assertEquals("stack is empty", e.getArtisanalErrorCode().getArtisanalErrorCode());
        }
    }

    @Test
    void testStackOverFlow() {
        ArtisanalStack stack = new ArtisanalStack();
        try {
            for (int i = 0; i < 1000; i++) {
                stack.push(i);
            }
        } catch (ArtisanalException e) {
            assertEquals("Stack overflow", e.getArtisanalErrorCode().getArtisanalErrorCode());
        }
    }
}
