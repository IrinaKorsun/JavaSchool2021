package sartakova.Factory;

import sartakova.GunsFactory;
import sartakova.Factory.beretta.BerettaSmoothbore;
import sartakova.Factory.beretta.BerettaSliced;
import sartakova.Factory.model.Smoothbore;
import sartakova.Factory.model.Sliced;



public class BerettaGunsFactory implements GunsFactory {
    @Override
    public Smoothbore createSmoothbore() {
        return new BerettaSmoothbore();
    }

    @Override
    public Sliced createSliced() {
    return new BerettaSliced();
    }

}
