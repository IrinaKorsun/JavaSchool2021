package zatsepin;

import org.junit.jupiter.api.Test;
import zatsepin.model.BadTestedClass2;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BadTestedClass2Test {

    @Test
    void badTestWithTwoBeforeAnnotatedMethods() throws Exception {
        assertThrows(Exception.class, () -> UnitClass.start(BadTestedClass2.class));
    }
}