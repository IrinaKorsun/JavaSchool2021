package zatsepin.model;

/**
 * General class for banknotes of 100.
 */
public abstract class BanknoteOf100 {

    /**
     * Banknote denomination
     */
    private static final int VALUE = 100;

    /**
     * @return value of the denomination of a banknote
     */
    public int getValue() {
        return VALUE;
    }
}
