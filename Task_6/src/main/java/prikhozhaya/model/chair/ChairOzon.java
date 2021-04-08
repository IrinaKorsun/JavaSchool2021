package prikhozhaya.model.chair;

public class ChairOzon extends AbstractChair {
    private String  provider = "Ozon";

    @Override
    public String toString() {
        return "Furniture naming: " + super.getName() + " (Provider: " +provider + ")";
    }
}
