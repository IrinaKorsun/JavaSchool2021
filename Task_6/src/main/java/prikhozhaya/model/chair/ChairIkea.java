package prikhozhaya.model.chair;

public class ChairIkea extends AbstractChair {
    private String  provider = "Ikea";

    @Override
    public String toString() {
        return "Furniture naming: " + super.getName() + " (Provider: " +provider + ")";
    }
}
