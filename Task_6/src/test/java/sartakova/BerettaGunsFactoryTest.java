package sartakova;
import org.junit.jupiter.api.Test;
import sartakova.Factory.BerettaGunsFactory;
import sartakova.GunsFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BerettaGunsFactoryTest {
        GunsFactory berettaFactory = new BerettaGunsFactory();

@Test
    void createSliced() {
            assertEquals("BerettaSliced", berettaFactory.createSliced().getClass().getSimpleName());
            }

@Test
    void createSmoothbore() {
            assertEquals("BerettaSmoothbore", berettaFactory.createSmoothbore().getClass().getSimpleName());
            }

            }