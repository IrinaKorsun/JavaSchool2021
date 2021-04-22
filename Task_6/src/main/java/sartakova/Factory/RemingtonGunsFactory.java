package sartakova.Factory;

import sartakova.GunsFactory;
import sartakova.Factory.model.Smoothbore;
import sartakova.Factory.model.Sliced;
import sartakova.Factory.Remington.RemingtonSmoothbore;
import sartakova.Factory.Remington.RemingtonSliced;



public class RemingtonGunsFactory implements GunsFactory {
    @Override
    public Smoothbore createSmoothbore() {
        return new RemingtonSmoothbore();
    }

    @Override
    public Sliced createSliced() {
    return new RemingtonSliced();
    }

}
