package galuza;

import galuza.exception.DoAfterAllException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

//Тест класса TestingClass3
public class TestByJunit3 {

    @Test
    void testDoAfterAllException() {
        assertThrows(DoAfterAllException.class, ()-> ThisIsTestStarter.start(TestingClass3.class));
    }
}