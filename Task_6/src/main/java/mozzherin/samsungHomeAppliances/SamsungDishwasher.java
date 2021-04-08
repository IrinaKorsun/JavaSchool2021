package mozzherin.samsungHomeAppliances;

import mozzherin.homeAppliances.Dishwasher;

import java.util.Objects;

public class SamsungDishwasher implements Dishwasher {
    private double waterFlow;
    private int capacity;

    public SamsungDishwasher(double waterFlow, int capacity) {
        this.waterFlow = waterFlow;
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SamsungDishwasher that = (SamsungDishwasher) o;
        return Double.compare(that.waterFlow, waterFlow) == 0 && capacity == that.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(waterFlow, capacity);
    }
}
