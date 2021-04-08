package mozzherin.factory;

import mozzherin.homeAppliances.Dishwasher;
import mozzherin.homeAppliances.Fridge;
import mozzherin.mieleHomeAppliances.MieleDishwasher;
import mozzherin.mieleHomeAppliances.MieleFridge;

public class MieleFactory implements HomeAppliancesFactory{
    @Override
    public Fridge createFridge(int volume, int numberOfCameras){
        return new MieleFridge(volume, numberOfCameras);
    }

    @Override
    public Dishwasher createDishwasher(double waterFlow, int capacity){
        return new MieleDishwasher(waterFlow, capacity);
    }
}
