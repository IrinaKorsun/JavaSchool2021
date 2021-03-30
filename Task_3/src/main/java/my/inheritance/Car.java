package my.inheritance;

import java.util.Objects;

public class Car {

    private String model;
    private int maxSpeed;
    private int yearOfManufacture;

    public Car() {
        System.out.println("Invoked Car");
        this.toString();
    }

    public Car(String model, int maxSpeed, int yearOfManufacture) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.yearOfManufacture = yearOfManufacture;
    }

    public void gas() {
        //... газ
        System.out.println("car gas");
    }

    public void brake() {
        //... тормоз
        System.out.println("car brake");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return maxSpeed == car.maxSpeed && yearOfManufacture == car.yearOfManufacture && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, yearOfManufacture);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", yearOfManufacture=" + yearOfManufacture +
                '}';
    }
}
