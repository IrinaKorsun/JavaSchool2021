package zatsepin.factory;

import zatsepin.model.BanknoteOf100;
import zatsepin.model.BanknoteOf50;

/**
 * Abstract factory for printing presses.
 */
public abstract class PrintingPressFactory {

    /**
     * @return denomination 50 banknote
     */
    public abstract BanknoteOf50 createBanknoteOf50();

    /**
     * @return denomination 100 banknote
     */
    public abstract BanknoteOf100 createBanknoteOf100();
}
