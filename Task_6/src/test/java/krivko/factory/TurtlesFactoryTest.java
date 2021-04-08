package krivko.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Задание 6
 * <br> Тест фабрики черепах
 * @author krivko
 * @version 1.1
 * @see TurtlesFactory
 */
class TurtlesFactoryTest {
    AnimalsFactory animals = new TurtlesFactory();

    @Test
    void createMeat() {
        assertEquals("TurtlesMeats", animals.createMeat().getClass().getSimpleName());
    }

    @Test
    void createEgg() {
        assertEquals("TurtlesEggs", animals.createEgg().getClass().getSimpleName());
    }

    @Test
    void createMilk() {
        assertEquals("TurtlesMilks", animals.createMilk().getClass().getSimpleName());
    }

    @Test
    void createFur() {
        assertEquals("TurtlesFurs", animals.createFur().getClass().getSimpleName());
    }
}