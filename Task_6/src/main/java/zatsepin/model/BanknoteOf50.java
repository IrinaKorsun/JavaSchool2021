package zatsepin.model;

/**
 * General class for banknotes of 50.
 */
public abstract class BanknoteOf50 {

    /**
     * Banknote denomination
     */
    private static final int VALUE = 50;

    /**
     * @return value of the denomination of a banknote
     */
    public int getValue() {
        return VALUE;
    }
}
