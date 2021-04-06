package bakunov.model;

import bakunov.DriveType;
import bakunov.exception.CarExceprion;
import bakunov.interfaces.Model;

public class CadillacEscalade extends Car implements Model {
    private final Engine engine;
    private final Boolean isLong;

    public CadillacEscalade(int makeYear, String color, DriveType driveType, Boolean isLong, Engine engine) {
        super(makeYear, color, driveType);
        this.engine = engine;
        this.isLong = isLong;
    }

    public Engine getEngine() {
        return engine;
    }

    public Boolean getLong() {
        return isLong;
    }


    @Override
    public String getModel() {
        if (isLong) {
            return "Cadillac Escalade ESV";
        } else {
            return "Cadillac Escalade";
        }
    }
}
