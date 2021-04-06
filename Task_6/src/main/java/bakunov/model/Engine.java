package bakunov.model;

import bakunov.EngineType;

public class Engine {
    private EngineType engineType;
    private String model;
    private int power;
    private int cylinders;

    public Engine(EngineType engineType, String model, int power, int cylinders) {
        this.engineType = engineType;
        this.model = model;
        this.power = power;
        this.cylinders = cylinders;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getCylinders() {
        return cylinders;
    }

    public EngineType getEngineType() {
        return engineType;
    }
}
