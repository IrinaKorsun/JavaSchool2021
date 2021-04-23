package sartakova;

import sartakova.factory.model.Smoothbore;
import sartakova.factory.model.Sliced;


public interface GunsFactory {
    Smoothbore createSmoothbore();

    Sliced createSliced();

}
