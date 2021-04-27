package sartakova.factory;

import sartakova.GunsFactory;
import sartakova.factory.model.Smoothbore;
import sartakova.factory.model.Sliced;
import sartakova.factory.remington.RemingtonSmoothbore;
import sartakova.factory.remington.RemingtonSliced;


public class RemingtonGunsFactory implements GunsFactory {
    /**
     *Создает новый объект класса RemingtonSmoothbore
     */
    @Override
    public Smoothbore createSmoothbore() {
        return new RemingtonSmoothbore();
    }

    /**
     *Создает новый объект класса RemingtonSliced
     */
    @Override
    public Sliced createSliced() {
    return new RemingtonSliced();
    }

}
