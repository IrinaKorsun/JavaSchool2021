package galuza.yamaha;

import galuza.BassGuitar;
import galuza.ElectricGuitar;
import galuza.Violin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestYamahaInstrumentFactory {
    @Test
    void testYamahaInstrumentFactory() {
        YamahaInstrumentFactory factory = new YamahaInstrumentFactory();
        ElectricGuitar yamahaTeleCaster = factory.createElectricGuitar();
        BassGuitar yamahaBass = factory.createBassGuitar();
        Violin yamahaViolin = factory.createViolin();

        assertAll(
                () -> assertEquals("Yamaha electric guitar sounds", yamahaTeleCaster.electricGuitarSounds()),
                () -> assertEquals("Yamaha bass sounds", yamahaBass.bassSounds()),
                () -> assertEquals("Yamaha violin sounds", yamahaViolin.violinSounds())
        );
    }
}
