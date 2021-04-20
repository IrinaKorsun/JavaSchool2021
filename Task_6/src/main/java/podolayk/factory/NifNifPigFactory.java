package podolayk.factory;

import podolayk.model.stoneHouse.NifNifStoneHouse;
import podolayk.model.stoneHouse.StoneHouse;
import podolayk.model.thatchedHouse.NifNifThatchedHouse;
import podolayk.model.thatchedHouse.ThatchedHouse;
import podolayk.model.woodHouse.NifNifWoodenHouse;
import podolayk.model.woodHouse.WoodenHouse;

/**
 * Фабрика Ниф-Нифа
 */

public class NifNifPigFactory implements HouseBuilderFactory {

    @Override
    public StoneHouse createStoneHouse() {
        return new NifNifStoneHouse();
    }

    @Override
    public WoodenHouse createWoodenHouse() {
        return new NifNifWoodenHouse();
    }

    @Override
    public ThatchedHouse createThatchedHouse() {
        return new NifNifThatchedHouse();
    }
}
