package pelipenko.manufacturing;

import org.junit.jupiter.api.Test;
import pelipenko.EmployeeCarFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BMWEmployeeCarFactoryTest {
    EmployeeCarFactory bmwFactory = new BMWEmployeeCarFactory();

    @Test
    void createDesigner() {
        assertEquals("BMWDesigner", bmwFactory.createDesigner().getClass().getSimpleName());
    }

    @Test
    void createEngineer() {
        assertEquals("BMWEngineer", bmwFactory.createEngineer().getClass().getSimpleName());
    }

    @Test
    void createManager() {
        assertEquals("BMWManager", bmwFactory.createManager().getClass().getSimpleName());
    }
}