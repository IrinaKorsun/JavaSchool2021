package bakunov.model;

import bakunov.DriveType;

public class Car {

    private final int makeYear;
    private final String color;
    private final DriveType driveType;

    public Car(int makeYear, String color, DriveType driveType) {
        this.makeYear = makeYear;
        this.color = color;
        this.driveType = driveType;
    }

    public int getMakeYear() {
        return makeYear;
    }

    public String getColor() {
        return color;
    }

    public DriveType getDriveType() {
        return driveType;
    }
}
