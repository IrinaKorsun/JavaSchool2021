package komissarov.factory;

import komissarov.model.Barbecue;
import komissarov.model.Chalagach;
import komissarov.model.Kebab;
import komissarov.model.Pilaf;

/**
 * Общий интерфейс мясного кафе
 * В кафе должны готовить шашлык,чалагач,кебаб,плов
 *
 * @autor komissarov
 */
public interface MeetCafe {
    Barbecue cookBarbecue();

    Chalagach cookChalagach();

    Kebab cookKebab();

    Pilaf cookPilaf();
}
