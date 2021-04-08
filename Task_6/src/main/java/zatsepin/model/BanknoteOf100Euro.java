package zatsepin.model;

/**
 * Class for 100 euro banknote.
 */
public class BanknoteOf100Euro extends BanknoteOf100 {

    /**
     * Banknote kind
     */
    private static final String KIND = "Euro";

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
        return "BanknoteOf100Euro";
    }
}
