package podolayk.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NifNifPigFactoryTest {

    HouseBuilderFactory builderFactory = new NifNifPigFactory();

    @Test
    void createWoodHouse() {
        assertEquals("NifNifWoodenHouse", builderFactory.createWoodenHouse().getClass().getSimpleName());
    }

    @Test
    void createStoneHouse() {
        assertEquals("NifNifStoneHouse", builderFactory.createStoneHouse().getClass().getSimpleName());
    }


    @Test
    void createThatchedHouse() {
        assertEquals("NifNifThatchedHouse", builderFactory.createThatchedHouse().getClass().getSimpleName());
    }
}