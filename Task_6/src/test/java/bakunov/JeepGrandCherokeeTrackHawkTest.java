package bakunov;

import bakunov.exception.CarExceprion;
import bakunov.factory.EngineFactory;
import bakunov.model.JeepGrandCherokeeSRT8;
import bakunov.model.JeepGrandCherokeeTrackHawk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JeepGrandCherokeeTrackHawkTest {
    private JeepGrandCherokeeTrackHawk grandCherokee;

    @BeforeEach
    void setUp() throws CarExceprion {
        grandCherokee = new JeepGrandCherokeeTrackHawk(2021, "Black", DriveType.AWD, EngineFactory.getEngineFactory().create(EngineType.HEMI_6_2_717));
    }

    @Test
    void testGetEngine() {
        assertEquals(EngineType.HEMI_6_2_717, grandCherokee.getEngine().getEngineType());
    }

    @Test
    void testGetModel() throws CarExceprion {
        assertEquals("Jeep Grand Cherokee TRACKHAWK", grandCherokee.getModel());
    }
}
