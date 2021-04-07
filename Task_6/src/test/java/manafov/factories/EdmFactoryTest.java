package manafov.factories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EdmFactoryTest {
    TracksFactory edm = new EdmFactory();

    @Test
    void createDrums() {
        assertEquals("EdmDrums", edm.createDrums().getClass().getSimpleName());
    }

    @Test
    void createBass() {
        assertEquals("EdmBass", edm.createBass().getClass().getSimpleName());
    }

    @Test
    void createRhythm() {
        assertEquals("EdmRhythm", edm.createRhythm().getClass().getSimpleName());
    }

    @Test
    void createVocals() {
        assertEquals("EdmVocals", edm.createVocals().getClass().getSimpleName());
    }

    @Test
    void createLead() {
        assertEquals("EdmLead", edm.createLead().getClass().getSimpleName());
    }
}
