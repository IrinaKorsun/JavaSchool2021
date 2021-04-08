package manafov.factories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PopFactoryTest {
    TracksFactory pop = new PopFactory();

    @Test
    void createDrums() {
        assertEquals("PopDrums", pop.createDrums().getClass().getSimpleName());
    }

    @Test
    void createBass() {
        assertEquals("PopBass", pop.createBass().getClass().getSimpleName());
    }

    @Test
    void createRhythm() {
        assertEquals("PopRhythm", pop.createRhythm().getClass().getSimpleName());
    }

    @Test
    void createVocals() {
        assertEquals("PopVocals", pop.createVocals().getClass().getSimpleName());
    }

    @Test
    void createLead() {
        assertEquals("PopLead", pop.createLead().getClass().getSimpleName());
    }
}
