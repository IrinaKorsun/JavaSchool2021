package ryzhenko.factory;

import ryzhenko.armours.Armour;
import ryzhenko.armours.SteelPlate;
import ryzhenko.salary.Salary;
import ryzhenko.weapons.Sword;
import ryzhenko.weapons.Weapon;

public class KnightFactory implements UnitFactory {
    @Override
    public Armour equipArmour() {
        return new SteelPlate();
    }

    @Override
    public Weapon equipWeapon() {
        return new Sword();
    }

    @Override
    public Salary unitCost() {
        return new Salary(50);
    }
}
