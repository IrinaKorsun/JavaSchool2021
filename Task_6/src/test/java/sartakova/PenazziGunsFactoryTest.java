package sartakova;

import org.junit.jupiter.api.Test;
import sartakova.Factory.PenazziGunsFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PenazziGunsFactoryTest {
    GunsFactory penazziFactory = new PenazziGunsFactory();

    @Test
    void createSliced() {
        assertEquals("PenazziSliced", penazziFactory.createSliced().getClass().getSimpleName());
    }

    @Test
    void createSmoothbore() {
        assertEquals("PenazziSmoothbore", penazziFactory.createSmoothbore().getClass().getSimpleName());
    }

}
