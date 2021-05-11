package galuza;

import galuza.exception.ThisIsTestException;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertThrows;

//Тест класса TestingClass4
public class TestByJunit4 {
    @Test
    void testThisIsTestException() {
        assertThrows(ThisIsTestException.class, ()-> ThisIsTestStarter.start(TestingClass4.class));
    }
}
