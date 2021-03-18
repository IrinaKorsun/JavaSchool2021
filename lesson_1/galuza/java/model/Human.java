package galuza.java.model;

import java.util.Objects;

public abstract class Human {
    private String firstNAme;
    private String lastName;
    private int age;

    public Human() {}

    public Human(String firstName, String lastName, int age) {
        this.firstNAme = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstNAme() {
        return firstNAme;
    }

    public void setFirstNAme(String firstNAme) {
        this.firstNAme = firstNAme;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getAge() == human.getAge() && Objects.equals(getFirstNAme(), human.getFirstNAme()) && Objects.equals(getLastName(), human.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstNAme(), getLastName(), getAge());
    }
}
