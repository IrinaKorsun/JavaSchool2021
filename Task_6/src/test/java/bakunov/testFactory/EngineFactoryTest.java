package bakunov.testFactory;

import bakunov.EngineType;
import bakunov.exception.CarExceprion;
import bakunov.factory.EngineFactory;
import bakunov.model.Engine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngineFactoryTest {
    private final EngineFactory engineFactory = EngineFactory.getEngineFactory();
    private Engine engine;

    @BeforeEach
    void setUp() throws CarExceprion {
        engine = engineFactory.create(EngineType.HEMI_6_2_717);
    }

    @Test
    void testCreateEngine() {
        assertEquals(EngineType.HEMI_6_2_717, engine.getEngineType());
    }

}
