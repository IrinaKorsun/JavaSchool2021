package zatsepin;

import org.junit.jupiter.api.Test;
import zatsepin.model.GoodTestedClass1;
import zatsepin.model.Result;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoodTestedClass1Test {

    @Test
    void goodTest() throws Exception {
        List<Object> results = UnitClass.start(GoodTestedClass1.class);
        assertEquals(Result.ZERO, results.get(0));
        assertEquals(Result.THREE, results.get(1));
        assertEquals(Result.TWO, results.get(2));
        assertEquals(Result.ONE, results.get(3));
        assertEquals(Result.NINE, results.get(4));
    }
}