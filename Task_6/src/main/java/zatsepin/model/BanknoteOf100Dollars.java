package zatsepin.model;

/**
 * Class for 100 dollars banknote.
 */
public class BanknoteOf100Dollars extends BanknoteOf100 {

    /**
     * Banknote kind
     */
    private static final String KIND = "Dollars";

    /**
     * @return kind of the banknote
     */
    public String getKind() {
        return KIND;
    }

    /**
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return "BanknoteOf100Dollars";
    }
}
