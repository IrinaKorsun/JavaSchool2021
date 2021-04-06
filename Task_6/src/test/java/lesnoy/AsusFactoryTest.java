package lesnoy;

import lesnoy.factory.AsusFactory;
import lesnoy.model.AsusDesktop;
import lesnoy.model.AsusNotebook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AsusFactoryTest {
    AsusFactory factory = new AsusFactory();

    @Test
    void createNotebook() {
        assertTrue(factory.createNotebook() instanceof AsusNotebook);
    }

    @Test
    void createDesktop() {
        assertTrue(factory.createDesktop() instanceof AsusDesktop);
    }
}