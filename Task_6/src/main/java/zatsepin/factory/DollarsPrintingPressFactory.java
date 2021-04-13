package zatsepin.factory;

import zatsepin.model.BanknoteOf100;
import zatsepin.model.BanknoteOf100Dollars;
import zatsepin.model.BanknoteOf50;
import zatsepin.model.BanknoteOf50Dollars;

/**
 * Factory for printing banknotes of dollars.
 */
public class DollarsPrintingPressFactory extends PrintingPressFactory {

    /**
     * @return denomination 50 dollars banknote
     */
    @Override
    public BanknoteOf50 createBanknoteOf50() {
        return new BanknoteOf50Dollars();
    }

    /**
     * @return denomination 100 dollars banknote
     */
    @Override
    public BanknoteOf100 createBanknoteOf100() {
        return new BanknoteOf100Dollars();
    }
}
