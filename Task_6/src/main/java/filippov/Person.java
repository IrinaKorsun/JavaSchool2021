package filippov;

/**
 * Абстрактный класс Person на базе которого создаются все персонажи
 * в классе персонажу задаются основные характеристики и имя
 * Реализован метод fight для сравнения с другим персонажем (сейчас только по полю health)
 */

public abstract class Person {
    protected int health;
    protected int power;
    protected int magic;
    protected int intellect;
    private String name;
    private PersonType personType;

    public Person(String name) {
        this.name = name;
        this.intellect = 50;
        this.power = 50;
        this.magic = 50;
        this.health = 50;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonType getPersonType() {
        return this.personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    @Override
    public String toString() {
        return ("Name: " + name + "; PersonType: " + personType + "; Health: " + health + "; Power: " + power + "; Magic:" + magic + " Intellect: " + intellect + ";");
    }

}
