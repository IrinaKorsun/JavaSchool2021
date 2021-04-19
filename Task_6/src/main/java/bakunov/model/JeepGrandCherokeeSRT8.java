package bakunov.model;

import bakunov.DriveType;
import bakunov.exception.CarExceprion;
import bakunov.interfaces.Model;

public class JeepGrandCherokeeSRT8 extends JeepGrandCherokee implements Model {
    public JeepGrandCherokeeSRT8(int makeYear, String color, DriveType driveType, Engine engine)  {
        super(makeYear, color, driveType, engine);
    }

    @Override
    public String getModel() {
        return "Jeep Grand Cherokee SRT8";
    }
}
