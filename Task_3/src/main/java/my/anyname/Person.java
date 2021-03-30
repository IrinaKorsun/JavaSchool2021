package my.anyname;

public class Person {
    private int age;
    private String name;
    private String city;
    private String region;
    private Boolean active;

    public Person() {
        this("Petya", "Other");
    }

    public Person(Boolean active) {
        this.active = active;
    }

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}
