package zatsepin.factory;

import zatsepin.model.BanknoteOf100;
import zatsepin.model.BanknoteOf100Rubles;
import zatsepin.model.BanknoteOf50;
import zatsepin.model.BanknoteOf50Rubles;

/**
 * Factory for printing banknotes of rubles.
 */
public class RublesPrintingPressFactory extends PrintingPressFactory {

    /**
     * @return denomination 50 rubles banknote
     */
    @Override
    public BanknoteOf50 createBanknoteOf50() {
        return new BanknoteOf50Rubles();
    }

    /**
     * @return denomination 100 rubles banknote
     */
    @Override
    public BanknoteOf100 createBanknoteOf100() {
        return new BanknoteOf100Rubles();
    }
}
