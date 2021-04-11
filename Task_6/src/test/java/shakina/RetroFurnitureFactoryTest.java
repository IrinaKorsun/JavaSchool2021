package shakina;

import org.junit.jupiter.api.Test;
import shakina.factories.FurnitureFactory;
import shakina.factories.RetroFurnitureFactory;
import shakina.furniture.bed.RetroBed;
import shakina.furniture.chair.RetroChair;
import shakina.furniture.couch.RetroCouch;
import shakina.furniture.table.RetroTable;
import shakina.furniture.wardrobe.RetroWardrobe;

import static org.junit.jupiter.api.Assertions.*;

class RetroFurnitureFactoryTest {

    FurnitureFactory factory = new RetroFurnitureFactory();

    @Test
    void makeBedTest() {
        assertEquals(RetroBed.class, factory.makeBed().getClass());
    }

    @Test
    void makeChairTest() {
        assertEquals(RetroChair.class, factory.makeChair().getClass());
    }

    @Test
    void makeCouchTest() {
        assertEquals(RetroCouch.class, factory.makeCouch().getClass());
    }

    @Test
    void makeTableTest() {
        assertEquals(RetroTable.class, factory.makeTable().getClass());
    }

    @Test
    void makeWardrobeTest() {
        assertEquals(RetroWardrobe.class, factory.makeWardrobe().getClass());
    }
}