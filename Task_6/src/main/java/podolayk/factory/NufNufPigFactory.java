package podolayk.factory;

import podolayk.model.stoneHouse.NufNufStoneHouse;
import podolayk.model.stoneHouse.StoneHouse;
import podolayk.model.thatchedHouse.NufNufThatchedHouse;
import podolayk.model.thatchedHouse.ThatchedHouse;
import podolayk.model.woodHouse.NufNufWoodenHouse;
import podolayk.model.woodHouse.WoodenHouse;

/**
 * Фабрика Нуф-Нуфа
 */

public class NufNufPigFactory implements HouseBuilderFactory {
    @Override
    public StoneHouse createStoneHouse() {
        return new NufNufStoneHouse();
    }

    @Override
    public WoodenHouse createWoodenHouse() {
        return new NufNufWoodenHouse();
    }

    @Override
    public ThatchedHouse createThatchedHouse() {
        return new NufNufThatchedHouse();
    }
}
