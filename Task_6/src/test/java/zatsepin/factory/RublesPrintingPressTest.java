package zatsepin.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RublesPrintingPressTest {

    private PrintingPressFactory factory;

    @BeforeEach
    void setUp() {
        factory = new RublesPrintingPressFactory();
    }

    @AfterEach
    void tearDown() {
        factory = null;
    }

    @Test
    void createBanknoteOf50Rubles() {
        String result = factory.createBanknoteOf50().toString();
        assertEquals("BanknoteOf50Rubles", result);
    }

    @Test
    void createBanknoteOf100Rubles() {
        String result = factory.createBanknoteOf100().toString();
        assertEquals("BanknoteOf100Rubles", result);
    }
}