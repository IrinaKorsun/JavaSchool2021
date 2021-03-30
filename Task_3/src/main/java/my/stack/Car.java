package my.stack;

public class Car {
    private int fuel;
    private int maxFuel;

    public Car(int fuel, int maxFuel) {
        this.fuel = fuel;
        this.maxFuel = maxFuel;
    }

    public int tankUp(int liter) {
        System.out.println("Пробую заправиться " + liter + " литрами");
        int remainingFuel = checkRemainingFuel();
        if (remainingFuel > 0) {
            System.out.println("Заправляюсь " + remainingFuel + " литрами");
        } else {
            System.out.println("Бак полон!");
        }

        return remainingFuel;
    }

    private int checkRemainingFuel() {
        return maxFuel - fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}
