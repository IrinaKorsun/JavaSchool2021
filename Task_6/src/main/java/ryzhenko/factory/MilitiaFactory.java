package ryzhenko.factory;

import ryzhenko.armours.Armour;
import ryzhenko.salary.Salary;
import ryzhenko.weapons.Spear;
import ryzhenko.weapons.Weapon;

public class MilitiaFactory implements UnitFactory {
    @Override
    public Armour equipArmour() {
        return null;
    }

    @Override
    public Weapon equipWeapon() {
        return new Spear();
    }

    @Override
    public Salary unitCost() {
        return new Salary(10);
    }
}
