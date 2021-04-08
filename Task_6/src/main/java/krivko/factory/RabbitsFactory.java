package krivko.factory;

import krivko.model.egg.Egg;
import krivko.model.egg.RabbitEgg;
import krivko.model.fur.Fur;
import krivko.model.fur.RabbitFur;
import krivko.model.meat.Meat;
import krivko.model.meat.RabbitMeat;
import krivko.model.milk.Milk;
import krivko.model.milk.RabbitMilk;

/**
 * Фабрика Кроликов
 */
public class RabbitsFactory implements AnimalsFactory {
    @Override
    public Meat createMeat() {
        return new RabbitMeat();
    }

    @Override
    public Egg createEgg() {
        return new RabbitEgg();
    }

    @Override
    public Milk createMilk() {
        return new RabbitMilk();
    }

    @Override
    public Fur createFur() {
        return new RabbitFur();
    }
}