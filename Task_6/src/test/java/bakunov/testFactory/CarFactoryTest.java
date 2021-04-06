package bakunov.testFactory;

import bakunov.CarType;
import bakunov.EngineType;
import bakunov.exception.CarExceprion;
import bakunov.factory.CarFactory;
import bakunov.model.CadillacEscalade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarFactoryTest {
    private final CarFactory carFactory = CarFactory.getCarFactory();
    private CadillacEscalade escalade;

    @BeforeEach
    void setUp() throws CarExceprion {
        escalade = (CadillacEscalade) carFactory.create(CarType.ESCALADE_ESV);
    }

    @Test
    void testCreateCar() {
        assertEquals("Cadillac Escalade ESV", escalade.getModel());
    }
}
