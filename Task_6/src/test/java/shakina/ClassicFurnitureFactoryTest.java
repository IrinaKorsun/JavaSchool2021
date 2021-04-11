package shakina;

import org.junit.jupiter.api.Test;
import shakina.factories.ClassicFurnitureFactory;
import shakina.factories.FurnitureFactory;
import shakina.furniture.bed.ClassicBed;
import shakina.furniture.chair.ClassicChair;
import shakina.furniture.couch.ClassicCouch;
import shakina.furniture.table.ClassicTable;
import shakina.furniture.wardrobe.ClassicWardrobe;

import static org.junit.jupiter.api.Assertions.*;

class ClassicFurnitureFactoryTest {

    FurnitureFactory factory = new ClassicFurnitureFactory();

    @Test
    void makeBedTest() {
        assertEquals(ClassicBed.class, factory.makeBed().getClass());
    }

    @Test
    void makeChairTest() {
        assertEquals(ClassicChair.class, factory.makeChair().getClass());
    }

    @Test
    void makeCouchTest() {
        assertEquals(ClassicCouch.class, factory.makeCouch().getClass());
    }

    @Test
    void makeTableTest() {
        assertEquals(ClassicTable.class, factory.makeTable().getClass());
    }

    @Test
    void makeWardrobeTest() {
        assertEquals(ClassicWardrobe.class, factory.makeWardrobe().getClass());
    }
}