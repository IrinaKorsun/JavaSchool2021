package ryzhenko;

import ryzhenko.factory.ArcherFactory;
import ryzhenko.factory.UnitFactory;
import ryzhenko.salary.Salary;
import ryzhenko.weapons.Bow;
import ryzhenko.armours.LeatherDoublet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArcherFactoryTest {

    private UnitFactory factory;

    @BeforeEach
    void setUp() {
        factory = new ArcherFactory();
    }

    @Test
    void addWeapon() {
        assertTrue(factory.equipWeapon() instanceof Bow);
    }

    @Test
    void addArmour() {
        assertTrue(factory.equipArmour() instanceof LeatherDoublet);
    }

    @Test
    void unitCost() { assertTrue(factory.unitCost() instanceof Salary); }
}