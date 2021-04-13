package krivko.factory;

import krivko.model.egg.Egg;
import krivko.model.egg.HamsterEgg;
import krivko.model.fur.Fur;
import krivko.model.fur.HamsterFur;
import krivko.model.meat.Meat;
import krivko.model.meat.HamsterMeat;
import krivko.model.milk.Milk;
import krivko.model.milk.HamsterMilk;

/**
 * Фабрика Хомяков
 */
public class HamstersFactory implements AnimalsFactory {
    @Override
    public Meat createMeat() {
        return new HamsterMeat();
    }

    @Override
    public Egg createEgg() {
        return new HamsterEgg();
    }

    @Override
    public Milk createMilk() {
        return new HamsterMilk();
    }

    @Override
    public Fur createFur() {
        return new HamsterFur();
    }
}