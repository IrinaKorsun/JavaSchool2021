package galuza;

import galuza.exception.DoAfterAllException;
import galuza.exception.DoBeforeAllException;
import galuza.exception.ThisIsTestException;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Тест класса TestingClass1
public class TestByJunit1 {
    @Test
    void testInvokedMethods() throws ThisIsTestException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, DoBeforeAllException, DoAfterAllException {
        List<Object> objects = ThisIsTestStarter.start(TestingClass1.class);
        assertAll(
                ()-> assertEquals("test method marked as @DoBeforeAll is done", objects.get(0)),
                ()-> assertEquals("test marked as @ThisIsTest is done", objects.get(1)),
                ()-> assertEquals("test marked as @ThisIsTest is done", objects.get(2)),
                ()-> assertEquals("test marked as @ThisIsTest is done", objects.get(3)),
                ()-> assertEquals("test marked as @ThisIsTest is done", objects.get(4)),
                ()-> assertEquals("test marked as @ThisIsTest is done", objects.get(5)),
                ()-> assertEquals("test method marked as @DoAfterAll is done", objects.get(6))
                );
    }

    @Test
    void testInvokedMethodsSize() throws ThisIsTestException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, DoBeforeAllException, DoAfterAllException {
        assertEquals(7, ThisIsTestStarter.start(TestingClass1.class).size());
    }
}
