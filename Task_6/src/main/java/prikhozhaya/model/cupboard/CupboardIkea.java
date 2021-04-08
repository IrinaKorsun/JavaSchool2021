package prikhozhaya.model.cupboard;

public class CupboardIkea extends AbstractCupboard {
    private String provider = "Ikea";

    @Override
    public String toString(){
        return "Furniture naming: " + super.getName() + " (Provider: " +provider + ")";
    }
}
