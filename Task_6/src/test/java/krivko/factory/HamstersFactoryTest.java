package krivko.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Задание 6
 * <br> Тест фабрики хомяков
 * @author krivko
 * @version 1.1
 * @see HamstersFactory
 */
class HamstersFactoryTest {
    AnimalsFactory animals = new HamstersFactory();

    @Test
    void createMeat() {
        assertEquals("HamstersMeats", animals.createMeat().getClass().getSimpleName());
    }

    @Test
    void createEgg() {
        assertEquals("HamstersEggs", animals.createEgg().getClass().getSimpleName());
    }

    @Test
    void createMilk() {
        assertEquals("HamstersMilks", animals.createMilk().getClass().getSimpleName());
    }

    @Test
    void createFur() {
        assertEquals("HamstersFurs", animals.createFur().getClass().getSimpleName());
    }
}