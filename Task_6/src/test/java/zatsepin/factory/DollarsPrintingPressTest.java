package zatsepin.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DollarsPrintingPressTest {

    private PrintingPressFactory factory;

    @BeforeEach
    void setUp() {
        factory = new DollarsPrintingPressFactory();
    }

    @AfterEach
    void tearDown() {
        factory = null;
    }

    @Test
    void createBanknoteOf50Dollars() {
        String result = factory.createBanknoteOf50().toString();
        assertEquals("BanknoteOf50Dollars", result);
    }

    @Test
    void createBanknoteOf100Dollars() {
        String result = factory.createBanknoteOf100().toString();
        assertEquals("BanknoteOf100Dollars", result);
    }
}