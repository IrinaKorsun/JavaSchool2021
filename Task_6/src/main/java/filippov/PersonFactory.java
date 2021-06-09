package filippov;

import filippov.dwarf.DwarfArcher;
import filippov.dwarf.DwarfWarrior;
import filippov.dwarf.DwarfWizard;
import filippov.human.HumanArcher;
import filippov.human.HumanWarrior;
import filippov.human.HumanWizard;

/**
 * Класс PersonFactory в котором реализована генерация персонажей различных рас и способностей
 * перечень которых содержится в ENUM PersonType, способности генерируются автоматически в диапазоне 50 - 100
 * Каждая раса имеет повышающие и понижающие коэффициенты в отдельном интерфейсе
 * Каждый класс песонажа может иметь свои коэффициенты и методы в отдельном интерфейсе
 * *
 *
 * @version 1.0
 * @since 08.05.2021
 */
public class PersonFactory {

    /**
     *
     * @param personName Имя персонажа
     * @param enumPersonType Тип персонажа из ENUM PersonType
     * @return Созданный персонаж
     */
    public Person createPerson(String personName, int enumPersonType) {
        Person person;
        PersonType personType;
        switch (enumPersonType) {
            case 0:
                person = new HumanWarrior();
                personType = PersonType.HUMAN_WARRIOR;
                break;
            case 1:
                person = new HumanWizard();
                personType = PersonType.HUMAN_WIZARD;
                break;
            case 2:
                person = new HumanArcher();
                personType = PersonType.HUMAN_ARCHER;
                break;
            case 3:
                person = new DwarfWarrior();
                personType = PersonType.DWARF_WARRIOR;
                break;
            case 4:
                person = new DwarfWizard();
                personType = PersonType.DWARF_WIZARD;
                break;
            case 5:
                person = new DwarfArcher();
                personType = PersonType.DWARF_ARCHER;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + enumPersonType);
        }
        person.setName(personName);
        person.setPersonType(personType);
        return person;
    }
}