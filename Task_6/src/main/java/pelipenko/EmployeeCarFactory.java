package pelipenko;

import pelipenko.manufacturing.model.Designer;
import pelipenko.manufacturing.model.Engineer;
import pelipenko.manufacturing.model.Manager;

public interface EmployeeCarFactory {
    Designer createDesigner();

    Engineer createEngineer();

    Manager createManager();

}
