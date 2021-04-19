package bakunov;

import bakunov.exception.CarExceprion;
import bakunov.factory.EngineFactory;
import bakunov.model.ChevroletTahoe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChevroletTahoeTest {
    private ChevroletTahoe tahoe;

    @BeforeEach
    void setUp() throws CarExceprion {
        tahoe = new ChevroletTahoe(2020, "White", DriveType.AWD, EngineFactory.getEngineFactory().create(EngineType.HEMI_6_2_409));
    }

    @Test
    void testGetEngine() {
        assertEquals(EngineType.HEMI_6_2_409, tahoe.getEngine().getEngineType());
    }

    @Test
    void testGetModel() {
        assertEquals("Chevrolet Tahoe", tahoe.getModel());
    }
}
