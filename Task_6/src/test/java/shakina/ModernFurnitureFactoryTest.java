package shakina;

import org.junit.jupiter.api.Test;
import shakina.factories.FurnitureFactory;
import shakina.factories.ModernFurnitureFactory;
import shakina.furniture.bed.ModernBed;
import shakina.furniture.chair.ModernChair;
import shakina.furniture.couch.ModernCouch;
import shakina.furniture.table.ModernTable;
import shakina.furniture.wardrobe.ModernWardrobe;

import static org.junit.jupiter.api.Assertions.*;

class ModernFurnitureFactoryTest {

    FurnitureFactory factory = new ModernFurnitureFactory();

    @Test
    void makeBedTest() {
        assertEquals(ModernBed.class, factory.makeBed().getClass());
    }

    @Test
    void makeChairTest() {
        assertEquals(ModernChair.class, factory.makeChair().getClass());
    }

    @Test
    void makeCouchTest() {
        assertEquals(ModernCouch.class, factory.makeCouch().getClass());
    }

    @Test
    void makeTableTest() {
        assertEquals(ModernTable.class, factory.makeTable().getClass());
    }

    @Test
    void makeWardrobeTest() {
        assertEquals(ModernWardrobe.class, factory.makeWardrobe().getClass());
    }
}