package sartakova.Factory;

import sartakova.GunsFactory;
import sartakova.Factory.Beretta.BerettaSmoothbore;
import sartakova.Factory.Beretta.BerettaSliced;
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
