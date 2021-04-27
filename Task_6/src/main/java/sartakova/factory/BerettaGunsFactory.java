package sartakova.factory;

import sartakova.GunsFactory;
import sartakova.factory.beretta.BerettaSmoothbore;
import sartakova.factory.beretta.BerettaSliced;
import sartakova.factory.model.Smoothbore;
import sartakova.factory.model.Sliced;


public class BerettaGunsFactory implements GunsFactory {
    /**
     *Создает новый объект класса BerettaSmoothbore
     */
    @Override
    public Smoothbore createSmoothbore() {
        return new BerettaSmoothbore();
    }

    /**
     *Создает новый объект класса BerettaSliced
     */
    @Override
    public Sliced createSliced() {
    return new BerettaSliced();
    }

}
