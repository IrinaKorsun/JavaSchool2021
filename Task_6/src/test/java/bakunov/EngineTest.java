package bakunov;

import bakunov.model.Car;
import bakunov.model.Engine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngineTest {
    private Engine engine;

    @BeforeEach
    void setUp() {
        engine = new Engine(EngineType.HEMI_6_2_717, "HEMI 6.2L", 717, 8);
    }

    @Test
    void testGetModel() {
        assertEquals("HEMI 6.2L", engine.getModel());
    }

    @Test
    void testGetPower() {
        assertEquals(717, engine.getPower());
    }

    @Test
    void testGetCylinders() {
        assertEquals(8, engine.getCylinders());
    }
}
