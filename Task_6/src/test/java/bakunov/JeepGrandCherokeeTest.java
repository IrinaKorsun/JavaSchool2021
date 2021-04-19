package bakunov;

import bakunov.exception.CarExceprion;
import bakunov.exception.CarExceptionCode;
import bakunov.factory.EngineFactory;
import bakunov.model.JeepGrandCherokee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JeepGrandCherokeeTest {
    private JeepGrandCherokee grandCherokee;

    @BeforeEach
    void setUp() throws CarExceprion {
        grandCherokee = new JeepGrandCherokee(2021, "Black", DriveType.AWD, EngineFactory.getEngineFactory().create(EngineType.PENTASTAR));
    }

    @Test
    void testGetEngine() {
        assertEquals(EngineType.PENTASTAR, grandCherokee.getEngine().getEngineType());
    }

    @Test
    void testGetModel() throws CarExceprion {
        assertEquals("Jeep Grand Cherokee", grandCherokee.getModel());
    }

    @Test
    void testUnknownEngine() throws CarExceprion {
        try {
            new JeepGrandCherokee(2021, "Black", DriveType.AWD, EngineFactory.getEngineFactory().create(EngineType.HEMI_6_2_426));
        } catch (CarExceprion ex) {
            assertEquals(CarExceptionCode.UNKNOWN_ENGINE, ex.getErrorCode());
        }
    }
}
