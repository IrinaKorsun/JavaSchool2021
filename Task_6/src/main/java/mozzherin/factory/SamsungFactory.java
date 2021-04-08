package mozzherin.factory;

import mozzherin.homeAppliances.Dishwasher;
import mozzherin.homeAppliances.Fridge;
import mozzherin.samsungHomeAppliances.SamsungDishwasher;
import mozzherin.samsungHomeAppliances.SamsungFridge;

public class SamsungFactory implements HomeAppliancesFactory {
    @Override
    public Fridge createFridge(int volume, int numberOfCameras) {
        return new SamsungFridge(volume, numberOfCameras);
    }

    @Override
    public Dishwasher createDishwasher(double waterFlow, int capacity) {
        return new SamsungDishwasher(waterFlow, capacity);
    }
}
