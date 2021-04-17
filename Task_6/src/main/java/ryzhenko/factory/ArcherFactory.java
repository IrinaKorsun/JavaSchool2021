package ryzhenko.factory;

import ryzhenko.armours.Armour;
import ryzhenko.armours.LeatherDoublet;
import ryzhenko.salary.Salary;
import ryzhenko.weapons.Bow;
import ryzhenko.weapons.Weapon;

public class ArcherFactory implements UnitFactory {
    @Override
    public Armour equipArmour() {
        return new LeatherDoublet();
    }

    @Override
    public Weapon equipWeapon() {
        return new Bow();
    }

    @Override
    public Salary unitCost() {
        return new Salary(25);
    }
}
