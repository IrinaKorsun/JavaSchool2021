package zatsepin;

import org.junit.jupiter.api.Test;
import zatsepin.model.BadTestedClass1;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BadTestedClass1Test {

    @Test
    void badTestWithTwoAfterAnnotatedMethods() throws Exception {
        assertThrows(Exception.class, () -> UnitClass.start(BadTestedClass1.class));
    }
}