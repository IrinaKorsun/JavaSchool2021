package podolayk.factory;

import podolayk.model.stoneHouse.StoneHouse;
import podolayk.model.thatchedHouse.ThatchedHouse;
import podolayk.model.woodHouse.WoodenHouse;

/**
 * Задание 6
 * Создание абстрактной фабрики для стоительных фирм поросят
 */
public interface HouseBuilderFactory {
    StoneHouse createStoneHouse();
    WoodenHouse createWoodenHouse();
    ThatchedHouse createThatchedHouse();
}
