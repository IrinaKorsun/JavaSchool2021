package mozzherin.mieleHomeAppliances;

import mozzherin.homeAppliances.Dishwasher;

import java.util.Objects;

public class MieleDishwasher implements Dishwasher {
    private double waterFlow;
    private int capacity;

    public MieleDishwasher(double waterFlow, int capacity) {
        this.waterFlow = waterFlow;
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MieleDishwasher that = (MieleDishwasher) o;
        return Double.compare(that.waterFlow, waterFlow) == 0 && capacity == that.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(waterFlow, capacity);
    }
}
