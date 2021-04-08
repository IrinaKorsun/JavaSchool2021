package zatsepin.model;

/**
 * Class for 50 euro banknote.
 */
public class BanknoteOf50Euro extends BanknoteOf50 {

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
        return "BanknoteOf50Euro";
    }
}
