package pelipenko.manufacturing;

import pelipenko.EmployeeCarFactory;
import pelipenko.manufacturing.lada.LadaDesigner;
import pelipenko.manufacturing.lada.LadaEngineer;
import pelipenko.manufacturing.lada.LadaManager;
import pelipenko.manufacturing.model.Designer;
import pelipenko.manufacturing.model.Engineer;
import pelipenko.manufacturing.model.Manager;

/**
 * Класс LadaConcernFactory релизующий интрефейс {@link EmployeeCarFactory}
 */

public class LadaEmployeeCarFactory implements EmployeeCarFactory {
    @Override
    public Designer createDesigner() {
        return new LadaDesigner();
    }

    @Override
    public Engineer createEngineer() {
    return new LadaEngineer();
    }

    @Override
    public Manager createManager() {
    return new LadaManager();
    }
}
