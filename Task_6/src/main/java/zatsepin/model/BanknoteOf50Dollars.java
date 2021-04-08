package zatsepin.model;

/**
 * Class for 50 dollars banknote.
 */
public class BanknoteOf50Dollars extends BanknoteOf50 {

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
        return "BanknoteOf50Dollars";
    }
}

