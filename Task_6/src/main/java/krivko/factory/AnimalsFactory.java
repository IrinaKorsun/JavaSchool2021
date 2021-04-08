package krivko.factory;

import krivko.model.egg.Egg;
import krivko.model.fur.Fur;
import krivko.model.meat.Meat;
import krivko.model.milk.Milk;

/**
 * Задание 6
 * <br> Абстрактная фабрика странной фермы
 * @author krivko
 * @version 1.1
 */
public interface AnimalsFactory {
    Meat createMeat();

    Egg createEgg();

    Milk createMilk();

    Fur createFur();
}