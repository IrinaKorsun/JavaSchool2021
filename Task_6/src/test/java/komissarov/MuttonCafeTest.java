package komissarov;

import komissarov.factory.MuttonCafe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MuttonCafeTest {
    MuttonCafe muttonCafe = new MuttonCafe();

    @Test
    void checkCookBarbecue() {
        assertEquals("MuttonBarbecue", muttonCafe.cookBarbecue().getClass().getSimpleName(),
                "Ошибка");
    }
    @Test
    void checkCookChalagach() {
        assertEquals("MuttonChalagach", muttonCafe.cookChalagach().getClass().getSimpleName(),
                "Ошибка");
    }
    @Test
    void checkCookKebab() {
        assertEquals("MuttonKebab", muttonCafe.cookKebab().getClass().getSimpleName(),
                "Ошибка");
    }
    @Test
    void checkCookPilaf() {
        assertEquals("MuttonPilaf", muttonCafe.cookPilaf().getClass().getSimpleName(),
                "Ошибка");
    }
}
