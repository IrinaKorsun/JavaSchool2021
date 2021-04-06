package bakunov.model;

import bakunov.DriveType;
import bakunov.exception.CarExceprion;
import bakunov.interfaces.Model;

public class JeepGrandCherokee extends Car implements Model {
    private final Engine engine;

    public JeepGrandCherokee(int makeYear, String color, DriveType driveType, Engine engine) {
        super(makeYear, color, driveType);
        this.engine = engine;

    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String getModel() {
        return "Jeep Grand Cherokee";
    }
}
