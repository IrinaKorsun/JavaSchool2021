package khoroshev.abstractfactory.model;

public class Human implements Workable {
    private String gender;
    private int age;
    private String mission;

    public Human(String gender, int age, String mission) {
        setGender(gender);
        setAge(age);
        setMission(mission);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    @Override
    public String work() {
        return "Мой гендер: " + getGender() + "\nМой возраст: " + getAge() + "\n" + getMission();
    }
}
