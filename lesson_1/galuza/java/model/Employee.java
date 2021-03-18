package galuza.java.model;

public class Employee extends Human implements Actionable{
    private String company;

    public Employee(String firstName, String lastName, int age, String company) {
        super(firstName, lastName, age);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public void walk() {
        System.out.println("I'm, " + getFirstNAme() + ", walk to work in " + getCompany());
    }

    @Override
    public void says(String words) {
        System.out.println("I'm, " + getFirstNAme() + ", let me speak from my heart: " + words);
    }
}
