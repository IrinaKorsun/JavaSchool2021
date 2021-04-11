package pelipenko.manufacturing;

import org.junit.jupiter.api.Test;
import pelipenko.EmployeeCarFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToyotaEmployeeCarFactoryTest {
    EmployeeCarFactory toyotaFactory = new ToyotaEmployeeCarFactory();

    @Test
    void createDesigner() {
        assertEquals("ToyotaDesigner", toyotaFactory.createDesigner().getClass().getSimpleName());
    }

    @Test
    void createEngineer() {
        assertEquals("ToyotaEngineer", toyotaFactory.createEngineer().getClass().getSimpleName());
    }

    @Test
    void createManager() {
        assertEquals("ToyotaManager", toyotaFactory.createManager().getClass().getSimpleName());
    }
}