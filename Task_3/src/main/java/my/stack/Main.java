package my.stack;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        crushHeap();
        Car subaru = new Car(5, 60);

        int plannedFuel = 70;
        int actualFuel = subaru.tankUp(plannedFuel);
        if (actualFuel < plannedFuel) {
            System.out.println("Где моя сдача? " + (plannedFuel - actualFuel));
        }
    }

    private static void crushHeap() {
        List<Car> cars = new ArrayList<>();
        int i = 0;
        while (true) {
            System.out.println("iteration " + ++i);
            cars.add(new Car(0, 0));
        }
    }
}
