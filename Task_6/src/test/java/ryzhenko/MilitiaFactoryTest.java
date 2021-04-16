package ryzhenko;

import ryzhenko.factory.MilitiaFactory;
import ryzhenko.factory.UnitFactory;
import ryzhenko.salary.Salary;
import ryzhenko.weapons.Spear;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MilitiaFactoryTest {

    private UnitFactory factory;

    @BeforeEach
    void setUp() {
        factory = new MilitiaFactory();
    }

    @Test
    void addWeapon() {
        assertTrue(factory.equipWeapon() instanceof Spear);
    }

    @Test
    void addArmour() {
        assertNull(factory.equipArmour());
    }

    @Test
    void unitCost() {
        assertTrue(factory.unitCost() instanceof Salary);
    }
}