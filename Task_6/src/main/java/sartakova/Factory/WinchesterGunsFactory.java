package sartakova.Factory;

import sartakova.Factory.Winchester.WinchesterSliced;
import sartakova.Factory.Winchester.WinchesterSmoothbore;
import sartakova.Factory.model.Sliced;
import sartakova.Factory.model.Smoothbore;
import sartakova.GunsFactory;


public class WinchesterGunsFactory implements GunsFactory {
    @Override
    public Smoothbore createSmoothbore() {
        return new WinchesterSmoothbore();
    }

    @Override
    public Sliced createSliced() {
        return new WinchesterSliced();
    }

}
