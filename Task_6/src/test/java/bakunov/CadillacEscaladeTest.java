package bakunov;

import bakunov.exception.CarExceprion;
import bakunov.factory.EngineFactory;
import bakunov.model.CadillacEscalade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadillacEscaladeTest {
    private CadillacEscalade escalade;

    @BeforeEach
    void setUp() throws CarExceprion {
        escalade = new CadillacEscalade(2020, "White", DriveType.AWD, true, EngineFactory.getEngineFactory().create(EngineType.HEMI_6_2_426));
    }

    @Test
    void testGetLong() {
        assertEquals(true, escalade.getLong());
    }

    @Test
    void testGetEngine() {
        assertEquals(EngineType.HEMI_6_2_426, escalade.getEngine().getEngineType());
    }

    @Test
    void testGetModel() {
        assertEquals("Cadillac Escalade ESV", escalade.getModel());
    }
}
