package prikhozhaya.model.table;

public class TableOzon extends AbstractTable {
    private String  provider = "Ozon";

    @Override
    public String toString() {
        return "Furniture naming: " + super.getName() + " (Provider: " +provider + ")";
    }
}
