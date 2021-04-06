package lesnoy;

import lesnoy.factory.DellFactory;
import lesnoy.model.DellDesktop;
import lesnoy.model.DellNotebook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DellFactoryTest {
    DellFactory factory = new DellFactory();

    @Test
    void createNotebook() {
        assertTrue(factory.createNotebook() instanceof DellNotebook);
    }

    @Test
    void createDesktop() {
        assertTrue(factory.createDesktop() instanceof DellDesktop);
    }


}