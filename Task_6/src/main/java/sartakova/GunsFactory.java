package sartakova;

import sartakova.Factory.model.Smoothbore;
import sartakova.Factory.model.Sliced;

public interface GunsFactory {
    Smoothbore createSmoothbore();

    Sliced createSliced();

}
