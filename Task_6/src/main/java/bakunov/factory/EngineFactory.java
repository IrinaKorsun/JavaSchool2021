package bakunov.factory;

import bakunov.EngineType;
import bakunov.exception.CarExceprion;
import bakunov.exception.CarExceptionCode;
import bakunov.model.Engine;

public class EngineFactory {
    private static EngineFactory engineFactory;

    private EngineFactory(){};

    public static EngineFactory getEngineFactory() {
        if (engineFactory == null) {
            engineFactory = new EngineFactory();
        }
        return engineFactory;
    }

    public Engine create(EngineType engineType) throws CarExceprion {
        switch (engineType) {
            case HEMI_5_7:
                return new Engine(EngineType.HEMI_5_7, "HEMI 5.7", 347, 8);
            case HEMI_6_2_717:
                return new Engine(EngineType.HEMI_6_2_717, "HEMI 6.2", 717, 8);
            case HEMI_6_2_426:
                return new Engine(EngineType.HEMI_6_2_426, "HEMI 6.2", 426, 8);
            case HEMI_6_2_409:
                return new Engine(EngineType.HEMI_6_2_409, "HEMI 6.2", 409, 8);
            case HEMI_6_4:
                return new Engine(EngineType.HEMI_6_4, "HEMI 6.4", 468, 8);
            case PENTASTAR:
                return new Engine(EngineType.PENTASTAR, "Pentastar", 286, 6);
            default:
                throw new CarExceprion(CarExceptionCode.UNKNOWN_ENGINE);
        }
    }
}
