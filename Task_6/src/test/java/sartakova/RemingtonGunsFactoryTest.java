package sartakova;

import org.junit.jupiter.api.Test;
import sartakova.factory.RemingtonGunsFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemingtonGunsFactoryTest {
    GunsFactory remingtonFactory = new RemingtonGunsFactory();

    @Test
    void createSliced() {
        assertEquals("RemingtonSliced", remingtonFactory.createSliced().getClass().getSimpleName());
    }

    @Test
    void createSmoothbore() {
        assertEquals("RemingtonSmoothbore", remingtonFactory.createSmoothbore().getClass().getSimpleName());
    }
}
