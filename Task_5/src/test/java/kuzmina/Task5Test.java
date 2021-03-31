package kuzmina;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task5Test {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calc() {
        Task5 a = new Task5();
        int result = a.calc(5, 6);
        assertEquals(11, result);
    }

    @Test
    void calc2() {
        Task5 a = new Task5();
        int result = a.calc(5, 6);
        assertEquals(11, result);
    }
}