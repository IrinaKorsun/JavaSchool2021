package komissarov.factory;

import komissarov.model.Barbecue;
import komissarov.model.Chalagach;
import komissarov.model.Kebab;
import komissarov.model.Pilaf;
import komissarov.model.pork.PorkBarbecue;
import komissarov.model.pork.PorkChalagach;
import komissarov.model.pork.PorkKebab;
import komissarov.model.pork.PorkPilaf;

/**
 * Класс MuttonCafe реализующий интерфейс MeetCafe
 *
 * @autor komissarov
 **/
public class PorkCafe implements MeetCafe {
    /**
     * Создает новый объект класса PorkBarbecue
     **/
    @Override
    public Barbecue cookBarbecue() {
        return new PorkBarbecue();
    }

    /**
     * Создает новый объект класса PorkChalagach
     **/
    @Override
    public Chalagach cookChalagach() {
        return new PorkChalagach();
    }

    /**
     * Создает новый объект класса PorkKebab
     **/
    @Override
    public Kebab cookKebab() {
        return new PorkKebab();
    }

    /**
     * Создает новый объект класса PorkPilaf
     **/
    @Override
    public Pilaf cookPilaf() {
        return new PorkPilaf();
    }
}
