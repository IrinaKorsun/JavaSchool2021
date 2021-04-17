package starikov.factories;

import starikov.enums.BanknoteCurrency;
import starikov.interfaces.BanknoteMachine;
import starikov.models.Banknote10;
import starikov.models.Banknote100;
import starikov.models.Banknote50;

/**
 * Станок для выпуска евро банкнот
 */
public class EuroBanknoteMachine implements BanknoteMachine {

    @Override
    public Banknote10 emitDenomination10() {
        return new Banknote10(BanknoteCurrency.EURO);
    }

    @Override
    public Banknote50 emitDenomination50() {
        return new Banknote50(BanknoteCurrency.EURO);
    }

    @Override
    public Banknote100 emitDenomination100() {
        return new Banknote100(BanknoteCurrency.EURO);
    }

    @Override
    public String printCurrency() {
        return BanknoteCurrency.EURO.getTitle();
    }
}
