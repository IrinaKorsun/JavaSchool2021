package bakunov.model;

import bakunov.DriveType;
import bakunov.exception.CarExceprion;
import bakunov.interfaces.Model;

public class JeepGrandCherokeeTrackHawk extends JeepGrandCherokee implements Model {
    public JeepGrandCherokeeTrackHawk(int makeYear, String color, DriveType driveType, Engine engine) {
        super(makeYear, color, driveType, engine);
    }

    @Override
    public String getModel() {
        return "Jeep Grand Cherokee TRACKHAWK";
    }
}
