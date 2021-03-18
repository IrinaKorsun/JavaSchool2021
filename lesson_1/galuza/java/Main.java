package galuza.java;

import galuza.java.model.Employee;

public class Main {

    public static void main(String[] args) {
        Employee jack = new Employee("Jack", "Robinson", 23, "Boston dynamics");
        jack.says("Hello World!");
        jack.walk();
    }
}