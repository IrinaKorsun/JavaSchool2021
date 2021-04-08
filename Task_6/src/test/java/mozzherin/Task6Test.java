package mozzherin;

import mozzherin.factory.HomeAppliancesFactory;
import mozzherin.factory.MieleFactory;
import mozzherin.factory.SamsungFactory;
import mozzherin.mieleHomeAppliances.MieleDishwasher;
import mozzherin.mieleHomeAppliances.MieleFridge;
import mozzherin.samsungHomeAppliances.SamsungDishwasher;
import mozzherin.samsungHomeAppliances.SamsungFridge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    HomeAppliancesFactory samsungFactory = new SamsungFactory();
    HomeAppliancesFactory mieleFactory = new MieleFactory();

    @Test
    void createSamsungDishwasher() {
        assertEquals(new SamsungDishwasher(4.4, 6), samsungFactory.createDishwasher(4.4, 6));
    }

    @Test
    void createSamsungFridhe() {
        assertEquals(new SamsungFridge(50, 2), samsungFactory.createFridge(50, 2));
    }

    @Test
    void createMieleDishwasher() {
        assertEquals(new MieleDishwasher(5, 7), mieleFactory.createDishwasher(5, 7));
    }

    @Test
    void createMieleFridhe() {
        assertEquals(new MieleFridge(45, 2), mieleFactory.createFridge(45, 2));
    }

}