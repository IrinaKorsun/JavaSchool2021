package galuza.fender;

import galuza.BassGuitar;
import galuza.ElectricGuitar;
import galuza.StringedInstrumentFactory;
import galuza.Violin;

public class FenderInstrumentFactory implements StringedInstrumentFactory {

    @Override
    public ElectricGuitar createElectricGuitar() {
        return new FenderElectricGuitar();
    }

    @Override
    public BassGuitar createBassGuitar() {
        return new FenderBassGuitar();
    }

    @Override
    public Violin createViolin() {
        return new FenderViolin();
    }
}
