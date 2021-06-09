package filippov.human;

import filippov.Person;
import filippov.personrace.Human;
import filippov.persontype.Archer;

/**
 * Класс для создания персонажа Human Archer
 * Задаем имя, используем поля родительского класса и константы имплементированного интерфейса
 * для определения финальных характеристик персонажа
 */

public class HumanArcher extends Person implements Human, Archer {

    public HumanArcher() {
        super("Человек-лучник");
        health = health * healthCoefficient / 100;
        power = power * powerCoefficient / 100;
        magic = magic * magicCoefficient / 100;
        intellect = intellect * intellectCoefficient / 100;
    }
}
