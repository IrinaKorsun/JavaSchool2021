package zatsepin.model;

/**
 * Class for 100 rubles banknote.
 */
public class BanknoteOf100Rubles extends BanknoteOf100 {

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
        return "BanknoteOf100Rubles";
    }
}
