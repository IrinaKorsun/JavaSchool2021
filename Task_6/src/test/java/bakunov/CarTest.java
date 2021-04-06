package bakunov;

import bakunov.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(2020, "White", DriveType.AWD);
    }

    @Test
    void testGetMakeYear() {
        assertEquals(2020, car.getMakeYear());
    }

    @Test
    void testGetColor() {
        assertEquals("White", car.getColor());
    }

    @Test
    void testGetDriveType() {
        assertEquals(DriveType.AWD, car.getDriveType());
    }
}
