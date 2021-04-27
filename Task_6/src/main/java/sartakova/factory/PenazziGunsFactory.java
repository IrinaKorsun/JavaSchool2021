package sartakova.factory;

import sartakova.GunsFactory;
import sartakova.factory.penazzi.PenazziSmoothbore;
import sartakova.factory.penazzi.PenazziSliced;
import sartakova.factory.model.Smoothbore;
import sartakova.factory.model.Sliced;



public class PenazziGunsFactory implements GunsFactory {
    /**
     *Создает новый объект класса PenazziSmoothbore
     */
    @Override
    public Smoothbore createSmoothbore() {
        return new PenazziSmoothbore();
    }

    /**
     *Создает новый объект класса PenazziSliced
     */
    @Override
    public Sliced createSliced() {
    return new PenazziSliced();
    }

}
