package starikov.models;

import starikov.enums.BanknoteCurrency;
import starikov.enums.BanknoteDenomination;
import starikov.interfaces.Denomination100;

/**
 * Модель банкноты достоинством 100
 */
public class Banknote100 extends Banknote implements Denomination100 {

    private final BanknoteCurrency currency;
    private final BanknoteDenomination nominal;

    public Banknote100(BanknoteCurrency currency) {
        super();
        this.currency = currency;
        this.nominal = BanknoteDenomination.ONEHANDRED;
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
