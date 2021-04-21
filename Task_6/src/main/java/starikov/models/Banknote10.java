package starikov.models;

import starikov.enums.BanknoteCurrency;
import starikov.enums.BanknoteDenomination;
import starikov.interfaces.Denomination10;

/**
 * Модель банкноты достоинством 10
 */
public class Banknote10 extends Banknote implements Denomination10 {

    private final BanknoteCurrency currency;
    private final BanknoteDenomination nominal;

    public Banknote10(BanknoteCurrency currency) {
        super();
        this.currency = currency;
        this.nominal = BanknoteDenomination.TEN;
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
