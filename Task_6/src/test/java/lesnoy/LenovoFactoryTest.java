package lesnoy;

import lesnoy.factory.LenovoFactory;
import lesnoy.model.LenovoDesktop;
import lesnoy.model.LenovoNotebook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LenovoFactoryTest {
    LenovoFactory factory = new LenovoFactory();

    @Test
    void createNotebook() {
        assertTrue(factory.createNotebook() instanceof LenovoNotebook);
    }

    @Test
    void createDesktop() {
        assertTrue(factory.createDesktop() instanceof LenovoDesktop);
    }
}