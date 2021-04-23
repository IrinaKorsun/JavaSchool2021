package podolayk.factory;

import podolayk.model.stoneHouse.NafNafStoneHouse;
import podolayk.model.stoneHouse.StoneHouse;
import podolayk.model.thatchedHouse.NafNafThatchedHouse;
import podolayk.model.thatchedHouse.ThatchedHouse;
import podolayk.model.woodHouse.NafNafWoodenHouse;
import podolayk.model.woodHouse.WoodenHouse;

/**
 * Фабрика Наф-Нафа
 */
public class NafNafPigFactory implements HouseBuilderFactory {

    @Override
    public WoodenHouse createWoodenHouse() { return new NafNafWoodenHouse(); }

    @Override
    public StoneHouse createStoneHouse() { return new NafNafStoneHouse(); }

    @Override
    public ThatchedHouse createThatchedHouse() {
        return new NafNafThatchedHouse();
    }
}
