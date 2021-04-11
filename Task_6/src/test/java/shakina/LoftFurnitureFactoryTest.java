package shakina;

import org.junit.jupiter.api.Test;
import shakina.factories.FurnitureFactory;
import shakina.factories.LoftFurnitureFactory;
import shakina.furniture.bed.LoftBed;
import shakina.furniture.chair.LoftChair;
import shakina.furniture.couch.LoftCouch;
import shakina.furniture.table.LoftTable;
import shakina.furniture.wardrobe.LoftWardrobe;

import static org.junit.jupiter.api.Assertions.*;

class LoftFurnitureFactoryTest {

    FurnitureFactory factory = new LoftFurnitureFactory();

    @Test
    void makeBedTest() {
        assertEquals(LoftBed.class, factory.makeBed().getClass());
    }

    @Test
    void makeChairTest() {
        assertEquals(LoftChair.class, factory.makeChair().getClass());
    }

    @Test
    void makeCouchTest() {
        assertEquals(LoftCouch.class, factory.makeCouch().getClass());
    }

    @Test
    void makeTableTest() {
        assertEquals(LoftTable.class, factory.makeTable().getClass());
    }

    @Test
    void makeWardrobeTest() {
        assertEquals(LoftWardrobe.class, factory.makeWardrobe().getClass());
    }
}