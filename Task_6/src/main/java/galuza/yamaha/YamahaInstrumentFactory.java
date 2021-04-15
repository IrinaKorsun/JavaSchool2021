package galuza.yamaha;

import galuza.BassGuitar;
import galuza.ElectricGuitar;
import galuza.StringedInstrumentFactory;
import galuza.Violin;

public class YamahaInstrumentFactory implements StringedInstrumentFactory {
    @Override
    public ElectricGuitar createElectricGuitar() {
        return new YamahaElectricGuitar();
    }

    @Override
    public BassGuitar createBassGuitar() {
        return new YamahaBassGuitar();
    }

    @Override
    public Violin createViolin() {
        return new YamahaViolin();
    }
}
