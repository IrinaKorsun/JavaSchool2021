package galuza;

import galuza.exception.DoBeforeAllException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

//Тест класса TestingClass2
public class TestByJunit2 {

    @Test
    void testDoBeforeAllException() {
        assertThrows(DoBeforeAllException.class, ()-> ThisIsTestStarter.start(TestingClass2.class));
    }
}