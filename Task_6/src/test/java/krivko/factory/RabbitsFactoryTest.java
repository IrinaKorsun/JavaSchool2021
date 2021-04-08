package krivko.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Задание 6
 * <br> Тест фабрики кроликов
 * @author krivko
 * @version 1.1
 * @see RabbitsFactory
 */
class RabbitsFactoryTest {
    AnimalsFactory animals = new RabbitsFactory();

    @Test
    void createMeat() {
        assertEquals("RabbitsMeats", animals.createMeat().getClass().getSimpleName());
    }

    @Test
    void createEgg() {
        assertEquals("RabbitsEggs", animals.createEgg().getClass().getSimpleName());
    }

    @Test
    void createMilk() {
        assertEquals("RabbitsMilks", animals.createMilk().getClass().getSimpleName());
    }

    @Test
    void createFur() {
        assertEquals("RabbitsFurs", animals.createFur().getClass().getSimpleName());
    }
}