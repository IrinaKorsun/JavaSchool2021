package komissarov;

import komissarov.factory.MuttonCafe;
import komissarov.factory.PorkCafe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PorkCafeTest {
        PorkCafe porkCafe = new PorkCafe();

        @Test
        void checkCookBarbecue() {
            assertEquals("PorkBarbecue", porkCafe.cookBarbecue().getClass().getSimpleName(),
                    "Ошибка");
        }
        @Test
        void checkCookChalagach() {
            assertEquals("PorkChalagach", porkCafe.cookChalagach().getClass().getSimpleName(),
                    "Ошибка");
        }
        @Test
        void checkCookKebab() {
            assertEquals("PorkKebab", porkCafe.cookKebab().getClass().getSimpleName(),
                    "Ошибка");
        }
        @Test
        void checkCookPilaf() {
            assertEquals("PorkPilaf", porkCafe.cookPilaf().getClass().getSimpleName(),
                    "Ошибка");
        }
}
