package podolayk.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NufNufPigFactoryTest {

    HouseBuilderFactory builderFactory = new NufNufPigFactory();

    @Test
    void createWoodHouse() {
        assertEquals("NufNufWoodenHouse", builderFactory.createWoodenHouse().getClass().getSimpleName());
    }

    @Test
    void createStoneHouse() {
        assertEquals("NufNufStoneHouse", builderFactory.createStoneHouse().getClass().getSimpleName());
    }

    @Test
    void createThatchedHouse() {
        assertEquals("NufNufThatchedHouse", builderFactory.createThatchedHouse().getClass().getSimpleName());
    }
}