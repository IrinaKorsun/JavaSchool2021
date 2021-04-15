package prikhozhaya.model.cupboard;

public class CupboardOzon extends AbstractCupboard {
    private String provider = "Ozon";

    @Override
    public String toString() {
        return "Furniture naming: " + super.getName() + " (Provider: " +provider + ")";
    }
}
