package filippov.dwarf;

import filippov.Person;
import filippov.personrace.Dwarf;
import filippov.persontype.Wizard;

/**
 * Класс для создания персонажа Dwarf Wizard
 * Задаем имя, используем поля родительского класса и константы имплементированного интерфейса
 * для определения финальных характеристик персонажа
 */

public class DwarfWizard extends Person implements Dwarf, Wizard {
    public DwarfWizard() {
        super("Дворф-маг");
        health = health * healthCoefficient / 100;
        power = power * powerCoefficient / 100;
        magic = magic * magicCoefficient / 100;
        intellect = intellect * intellectCoefficient / 100;
    }
}
