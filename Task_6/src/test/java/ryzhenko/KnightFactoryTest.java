package ryzhenko;

import ryzhenko.factory.KnightFactory;
import ryzhenko.factory.UnitFactory;
import ryzhenko.salary.Salary;
import ryzhenko.weapons.Sword;
import ryzhenko.armours.SteelPlate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightFactoryTest {

    private UnitFactory factory;

    @BeforeEach
    void setUp() {
        factory = new KnightFactory();
    }

    @Test
    void addWeapon() { assertTrue(factory.equipWeapon() instanceof Sword); }

    @Test
    void addArmour() {
        assertTrue(factory.equipArmour() instanceof SteelPlate);
    }

    @Test
    void unitCost() { assertTrue(factory.unitCost() instanceof Salary); }
}