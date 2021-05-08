package filippov.human;

import filippov.Person;
import filippov.personrace.Human;
import filippov.persontype.Wizard;

/**
 * Класс для создания персонажа Human Wizard
 * Задаем имя, используем поля родительского класса и константы имплементированного интерфейса
 * для определения финальных характеристик персонажа
 */

public class HumanWizard extends Person implements Human, Wizard {
    public HumanWizard() {
        super("Человек-маг");
        health = health * healthCoefficient / 100;
        power = power * powerCoefficient / 100;
        magic = magic * magicCoefficient / 100;
        intellect = intellect * intellectCoefficient / 100;
    }
}
