package sartakova.factory;

import sartakova.factory.winchester.WinchesterSliced;
import sartakova.factory.winchester.WinchesterSmoothbore;
import sartakova.factory.model.Sliced;
import sartakova.factory.model.Smoothbore;
import sartakova.GunsFactory;


public class WinchesterGunsFactory implements GunsFactory {
    /**
     *Создает новый объект класса WinchesterSmoothbore
     */
    @Override
    public Smoothbore createSmoothbore() {
        return new WinchesterSmoothbore();
    }

    /**
     *Создает новый объект класса WinchesterSliced
     */
    @Override
    public Sliced createSliced() {
        return new WinchesterSliced();
    }

}
