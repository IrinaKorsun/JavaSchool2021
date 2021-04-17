package starikov.models;

import starikov.enums.BanknoteCurrency;
import starikov.enums.BanknoteDenomination;
import starikov.interfaces.Denomination50;

/**
 * Модель банкноты достоинством 50
 */
public class Banknote50 extends Banknote implements Denomination50 {

    private final BanknoteCurrency currency;
    private final BanknoteDenomination nominal;

    public Banknote50(BanknoteCurrency currency) {
        super();
        this.currency = currency;
        this.nominal = BanknoteDenomination.FIFTY;
    }

    public BanknoteCurrency getCurrency() {
        return currency;
    }

    public BanknoteDenomination getNominal() {
        return nominal;
    }

    @Override
    public String printDenomination() {
        return nominal.getTitle();
    }
}
