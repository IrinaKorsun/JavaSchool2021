package zatsepin;

import org.junit.jupiter.api.Test;
import zatsepin.model.GoodTestedClass2;
import zatsepin.model.Result;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoodTestedClass2Test {

    @Test
    void goodTest() throws Exception {
        List<Object> results = UnitClass.start(GoodTestedClass2.class);
        assertEquals(Result.ZERO, results.get(0));
        assertEquals(Result.THREE, results.get(1));
        assertEquals(Result.TWO, results.get(2));
        assertEquals(Result.ONE, results.get(3));
        assertEquals(Result.NINE, results.get(4));
    }
}