package sartakova;

import org.junit.jupiter.api.Test;
import sartakova.Factory.WinchesterGunsFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinchesterGunsFactoryTest {
    GunsFactory winchesterFactory = new WinchesterGunsFactory();

    @Test
    void createSliced() {
        assertEquals("WinchesterSliced", winchesterFactory.createSliced().getClass().getSimpleName());
    }

    @Test
    void createSmoothbore() {
        assertEquals("WinchesterSmoothbore", winchesterFactory.createSmoothbore().getClass().getSimpleName());
    }

}
