package bakunov;

import bakunov.exception.CarExceprion;
import bakunov.factory.EngineFactory;
import bakunov.model.JeepGrandCherokeeSRT8;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JeepGrandCherokeeSRT8Test {
    private JeepGrandCherokeeSRT8 grandCherokee;

    @BeforeEach
    void setUp() throws CarExceprion {
        grandCherokee = new JeepGrandCherokeeSRT8(2021, "Black", DriveType.AWD, EngineFactory.getEngineFactory().create(EngineType.HEMI_6_4));
    }

    @Test
    void testGetEngine() {
        assertEquals(EngineType.HEMI_6_4, grandCherokee.getEngine().getEngineType());
    }

    @Test
    void testGetModel() throws CarExceprion {
        assertEquals("Jeep Grand Cherokee SRT8", grandCherokee.getModel());
    }
}
