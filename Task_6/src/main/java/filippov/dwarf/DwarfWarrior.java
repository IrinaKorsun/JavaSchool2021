package filippov.dwarf;

import filippov.Person;
import filippov.personrace.Dwarf;
import filippov.persontype.Warrior;

/**
 * Класс для создания персонажа Dwarf Warrior
 * Задаем имя, используем поля родительского класса и константы имплементированного интерфейса
 * для определения финальных характеристик персонажа
 */

public class DwarfWarrior extends Person implements Dwarf, Warrior {
    public DwarfWarrior() {
        super("Дворф-воин");
        health = health * healthCoefficient / 100;
        power = power * powerCoefficient / 100;
        magic = magic * magicCoefficient / 100;
        intellect = intellect * intellectCoefficient / 100;
    }
}
