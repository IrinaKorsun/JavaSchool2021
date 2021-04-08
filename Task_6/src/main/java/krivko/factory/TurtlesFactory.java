package krivko.factory;

import krivko.model.egg.Egg;
import krivko.model.egg.TurtleEgg;
import krivko.model.fur.Fur;
import krivko.model.fur.TurtleFur;
import krivko.model.meat.Meat;
import krivko.model.meat.TurtleMeat;
import krivko.model.milk.Milk;
import krivko.model.milk.TurtleMilk;

/**
 * Фабрика Черепах
 */
public class TurtlesFactory implements AnimalsFactory{
    @Override
    public Meat createMeat() {
        return new TurtleMeat();
    }

    @Override
    public Egg createEgg() {
        return new TurtleEgg();
    }

    @Override
    public Milk createMilk() {
        return new TurtleMilk();
    }

    @Override
    public Fur createFur() {
        return new TurtleFur();
    }
}