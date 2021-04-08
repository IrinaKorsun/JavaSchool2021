package prikhozhaya.model.table;

public class TableIkea extends AbstractTable {
    private String  provider = "Ikea";

    @Override
    public String toString() {
        return "Furniture naming: " + super.getName() + " (Provider: " +provider + ")";
    }
}
