package prikhozhaya.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OzonFactoryTest {
    private OzonFactory orderProvider = new OzonFactory();

    @Test
    void makeOrder() {
        assertEquals("Furniture naming: Chair (Provider: Ozon)", orderProvider.createChair().toString());
    }

    @Test
    void createCupboard() {
        assertEquals("Furniture naming: Cupboard (Provider: Ozon)", orderProvider.createCupboard().toString());
    }

    @Test
    void createTable() {
        assertEquals("Furniture naming: Table (Provider: Ozon)", orderProvider.createTable().toString());
    }
}