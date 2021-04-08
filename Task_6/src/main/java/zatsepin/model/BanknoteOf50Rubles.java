package zatsepin.model;

/**
 * Class for 50 rubles banknote.
 */
public class BanknoteOf50Rubles extends BanknoteOf50 {

    /**
     * Banknote kind
     */
    private static final String KIND = "Rubles";

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
        return "BanknoteOf50Rubles";
    }
}
