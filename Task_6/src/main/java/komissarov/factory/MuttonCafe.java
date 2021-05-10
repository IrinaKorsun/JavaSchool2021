package komissarov.factory;

import komissarov.model.Barbecue;
import komissarov.model.Chalagach;
import komissarov.model.Kebab;
import komissarov.model.Pilaf;
import komissarov.model.mutton.MuttonBarbecue;
import komissarov.model.mutton.MuttonChalagach;
import komissarov.model.mutton.MuttonKebab;
import komissarov.model.mutton.MuttonPilaf;

/**
 * Класс MuttonCafe реализующий интерфейс MeetCafe
 *
 * @autor komissarov
 **/
public class MuttonCafe implements MeetCafe {
    /**
     * Создает новый объект класса MuttonBarbecue
     **/
    @Override
    public Barbecue cookBarbecue() {
        return new MuttonBarbecue();
    }

    /**
     * Создает новый объект класса MuttonChalagach
     **/
    @Override
    public Chalagach cookChalagach() {
        return new MuttonChalagach();
    }

    /**
     * Создает новый объект класса MuttonKebab
     **/
    @Override
    public Kebab cookKebab() {
        return new MuttonKebab();
    }

    /**
     * Создает новый объект класса MuttonPilaf
     **/
    @Override
    public Pilaf cookPilaf() {
        return new MuttonPilaf();
    }
}
