package mozzherin.factory;

import mozzherin.homeAppliances.Dishwasher;
import mozzherin.homeAppliances.Fridge;

public interface HomeAppliancesFactory {
    Fridge createFridge(int volume, int numberOfCameras);
    Dishwasher createDishwasher(double waterFlow, int capacity);
}
