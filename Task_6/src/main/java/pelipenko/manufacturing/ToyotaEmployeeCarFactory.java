package pelipenko.manufacturing;

import pelipenko.EmployeeCarFactory;

import pelipenko.manufacturing.toyota.ToyotaDesigner;
import pelipenko.manufacturing.toyota.ToyotaEngineer;
import pelipenko.manufacturing.toyota.ToyotaManager;
import pelipenko.manufacturing.model.Designer;
import pelipenko.manufacturing.model.Engineer;
import pelipenko.manufacturing.model.Manager;

/**
 * Класс ToyotaConcernFactory релизующий интрефейс {@link EmployeeCarFactory}
 */

public class ToyotaEmployeeCarFactory implements EmployeeCarFactory {
    @Override
    public Designer createDesigner() {
        return new ToyotaDesigner();
    }

    @Override
    public Engineer createEngineer() {
    return new ToyotaEngineer();
    }

    @Override
    public Manager createManager() {
    return new ToyotaManager();
    }
}
