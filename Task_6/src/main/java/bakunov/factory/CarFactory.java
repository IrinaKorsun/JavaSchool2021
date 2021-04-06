package bakunov.factory;

import bakunov.CarType;
import bakunov.DriveType;
import bakunov.EngineType;
import bakunov.exception.CarExceprion;
import bakunov.exception.CarExceptionCode;
import bakunov.model.*;

public class CarFactory {
    private static CarFactory carFactory;
    private EngineFactory engineFactory = EngineFactory.getEngineFactory();

    private CarFactory(){};

    public static CarFactory getCarFactory() {
        if (carFactory == null) {
            carFactory = new CarFactory();
        }
        return carFactory;
    }

    public Car create(CarType carType) throws CarExceprion {
        switch (carType) {
            case ESCALADE:
                return new CadillacEscalade(2016, "Black", DriveType.AWD, false, engineFactory.create(EngineType.HEMI_6_2_426));
            case ESCALADE_ESV:
                return new CadillacEscalade(2016, "Black", DriveType.AWD, true, engineFactory.create(EngineType.HEMI_6_2_426));
            case GRAND_CHEROKEE:
                return new JeepGrandCherokee(2013, "White", DriveType.AWD, engineFactory.create(EngineType.PENTASTAR));
            case GRAND_CHEROKEE_SRT8:
                return new JeepGrandCherokeeSRT8(2013, "White", DriveType.AWD, engineFactory.create(EngineType.HEMI_6_4));
            case GRAND_CHEROKEE_TRACKHAWK:
                return new JeepGrandCherokeeTrackHawk(2013, "White", DriveType.AWD, engineFactory.create(EngineType.HEMI_6_2_717));
            case TAHOE:
                return new ChevroletTahoe(2013, "RED", DriveType.AWD, engineFactory.create(EngineType.HEMI_6_2_409));
            default:
                throw new CarExceprion(CarExceptionCode.UNKNOWN_MODEL);
        }
    }
}
