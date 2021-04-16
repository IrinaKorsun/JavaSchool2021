package ryzhenko.factory;

import ryzhenko.armours.Armour;
import ryzhenko.salary.Salary;
import ryzhenko.weapons.Weapon;

public interface UnitFactory {
    Armour equipArmour();

    Weapon equipWeapon();

    Salary unitCost();
}
