package pelipenko.manufacturing;

import pelipenko.EmployeeCarFactory;
import pelipenko.manufacturing.bmw.BMWDesigner;
import pelipenko.manufacturing.bmw.BMWEngineer;
import pelipenko.manufacturing.bmw.BMWManager;
import pelipenko.manufacturing.model.Designer;
import pelipenko.manufacturing.model.Engineer;
import pelipenko.manufacturing.model.Manager;

/**
 * Класс BMWConcernFactory релизующий интрефейс {@link EmployeeCarFactory}
 */
public class BMWEmployeeCarFactory implements EmployeeCarFactory {
    @Override
    public Designer createDesigner() {
        return new BMWDesigner();
    }

    @Override
    public Engineer createEngineer() {
    return new BMWEngineer();
    }

    @Override
    public Manager createManager() {
    return new BMWManager();
    }
}
