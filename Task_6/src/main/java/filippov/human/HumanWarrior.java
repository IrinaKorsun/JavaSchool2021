package filippov.human;

import filippov.Person;
import filippov.personrace.Human;
import filippov.persontype.Warrior;

/**
 * Класс для создания персонажа Human Warrior
 * Задаем имя, используем поля родительского класса и константы имплементированного интерфейса
 * для определения финальных характеристик персонажа
 */

public class HumanWarrior extends Person implements Human, Warrior {
    public HumanWarrior() {
        super("Человек-воин");
        health = health * healthCoefficient / 100;
        power = power * powerCoefficient / 100;
        magic = magic * magicCoefficient / 100;
        intellect = intellect * intellectCoefficient / 100;
    }
}
