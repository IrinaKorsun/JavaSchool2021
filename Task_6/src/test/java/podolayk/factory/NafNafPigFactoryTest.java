package podolayk.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NafNafPigFactoryTest {

    HouseBuilderFactory builder = new NafNafPigFactory();

    @Test
    void createWoodHouse() {
        assertEquals("NafNafWoodenHouse", builder.createWoodenHouse().getClass().getSimpleName());
    }

    @Test
    void createStoneHouse() {
        assertEquals("NafNafStoneHouse", builder.createStoneHouse().getClass().getSimpleName());
    }

    @Test
    void createThatchedHouse() {
        assertEquals("NafNafThatchedHouse", builder.createThatchedHouse().getClass().getSimpleName());
    }
}