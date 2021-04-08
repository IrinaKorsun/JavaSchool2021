package mozzherin.samsungHomeAppliances;

import mozzherin.homeAppliances.Fridge;

import java.util.Objects;

public class SamsungFridge implements Fridge {
    private int volume;
    private int numberOfCameras;

    public SamsungFridge(int volume, int numberOfCameras) {
        this.volume = volume;
        this.numberOfCameras = numberOfCameras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SamsungFridge that = (SamsungFridge) o;
        return volume == that.volume && numberOfCameras == that.numberOfCameras;
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, numberOfCameras);
    }
}
