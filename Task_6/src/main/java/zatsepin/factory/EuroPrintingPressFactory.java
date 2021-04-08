package zatsepin.factory;

import zatsepin.model.BanknoteOf100;
import zatsepin.model.BanknoteOf100Euro;
import zatsepin.model.BanknoteOf50;
import zatsepin.model.BanknoteOf50Euro;

/**
 * Factory for printing banknotes of euro.
 */
public class EuroPrintingPressFactory extends PrintingPressFactory {

    /**
     * @return denomination 50 euro banknote
     */
    @Override
    public BanknoteOf50 createBanknoteOf50() {
        return new BanknoteOf50Euro();
    }

    /**
     * @return denomination 100 euro banknote
     */
    @Override
    public BanknoteOf100 createBanknoteOf100() {
        return new BanknoteOf100Euro();
    }
}
