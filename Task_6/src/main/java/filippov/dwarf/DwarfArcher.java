package filippov.dwarf;

import filippov.Person;
import filippov.personrace.Dwarf;
import filippov.persontype.Archer;

/**
 * Класс для создания персонажа Dwarf Archer
 * Задаем имя, используем поля родительского класса и константы имплементированного интерфейса
 * для определения финальных характеристик персонажа
 */

public class DwarfArcher extends Person implements Dwarf, Archer {
    public DwarfArcher() {
        super("Дворф-лучник");
        health = health * healthCoefficient / 100;
        power = power * powerCoefficient / 100;
        magic = magic * magicCoefficient / 100;
        intellect = intellect * intellectCoefficient / 100;
    }
}
