package sartakova.Factory;

import sartakova.GunsFactory;
import sartakova.Factory.Penazzi.PenazziSmoothbore;
import sartakova.Factory.Penazzi.PenazziSliced;
import sartakova.Factory.model.Smoothbore;
import sartakova.Factory.model.Sliced;



public class PenazziGunsFactory implements GunsFactory {
    @Override
    public Smoothbore createSmoothbore() {
        return new PenazziSmoothbore();
    }

    @Override
    public Sliced createSliced() {
    return new PenazziSliced();
    }

}
