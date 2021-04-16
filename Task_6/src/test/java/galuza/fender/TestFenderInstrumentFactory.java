package galuza.fender;

import galuza.BassGuitar;
import galuza.ElectricGuitar;
import galuza.Violin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFenderInstrumentFactory {

    @Test
    void testFenderInstrumentFactory() {
        FenderInstrumentFactory factory = new FenderInstrumentFactory();
        ElectricGuitar fenderStratocaster = factory.createElectricGuitar();
        BassGuitar fenderBass = factory.createBassGuitar();
        Violin fenderViolin = factory.createViolin();

        assertAll(
                () -> assertEquals("Fender electric guitar sounds", fenderStratocaster.electricGuitarSounds()),
                () -> assertEquals("Fender bass sounds", fenderBass.bassSounds()),
                () -> assertEquals("Fender violin sounds", fenderViolin.violinSounds())
        );
    }
}
