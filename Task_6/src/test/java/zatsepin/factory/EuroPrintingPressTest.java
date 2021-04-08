package zatsepin.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuroPrintingPressTest {

    private PrintingPressFactory factory;

    @BeforeEach
    void setUp() {
        factory = new EuroPrintingPressFactory();
    }

    @AfterEach
    void tearDown() {
        factory = null;
    }

    @Test
    void createBanknoteOf50Euro() {
        String result = factory.createBanknoteOf50().toString();
        assertEquals("BanknoteOf50Euro", result);
    }

    @Test
    void createBanknoteOf100Euro() {
        String result = factory.createBanknoteOf100().toString();
        assertEquals("BanknoteOf100Euro", result);
    }
}