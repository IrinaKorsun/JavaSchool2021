package prikhozhaya.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IkeaFactoryTest {
    private IkeaFactory orderProvider = new IkeaFactory();

    @Test
    void makeOrder() {
        assertEquals("Furniture naming: Chair (Provider: Ikea)", orderProvider.createChair().toString());
    }

    @Test
    void createCupboard() {
        assertEquals("Furniture naming: Cupboard (Provider: Ikea)", orderProvider.createCupboard().toString());
    }

    @Test
    void createTable() {
        assertEquals("Furniture naming: Table (Provider: Ikea)", orderProvider.createTable().toString());
    }
}