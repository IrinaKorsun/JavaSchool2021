package manafov.factories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MetalFactoryTest {
    TracksFactory metal = new MetalFactory();

    @Test
    void createDrums() {
        assertEquals("MetalDrums", metal.createDrums().getClass().getSimpleName());
    }

    @Test
    void createBass() {
        assertEquals("MetalBass", metal.createBass().getClass().getSimpleName());
    }

    @Test
    void createRhythm() {
        assertEquals("MetalRhythm", metal.createRhythm().getClass().getSimpleName());
    }

    @Test
    void createVocals() {
        assertEquals("MetalVocals", metal.createVocals().getClass().getSimpleName());
    }

    @Test
    void createLead() {
        assertEquals("MetalLead", metal.createLead().getClass().getSimpleName());
    }
}
