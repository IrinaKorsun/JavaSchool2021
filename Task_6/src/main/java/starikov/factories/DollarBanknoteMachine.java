package starikov.factories;

import starikov.enums.BanknoteCurrency;
import starikov.interfaces.BanknoteMachine;
import starikov.models.Banknote10;
import starikov.models.Banknote50;
import starikov.models.Banknote100;

/**
 * Станок для выпуска долларовых банкнот
 */
public class DollarBanknoteMachine implements BanknoteMachine {

    @Override
    public Banknote10 emitDenomination10() {
         return new Banknote10(BanknoteCurrency.DOLLAR);
    }

    @Override
    public Banknote50 emitDenomination50() {
        return new Banknote50(BanknoteCurrency.DOLLAR);
    }

    @Override
    public Banknote100 emitDenomination100() {
        return new Banknote100(BanknoteCurrency.DOLLAR);
    }

    @Override
    public String printCurrency() {
        return BanknoteCurrency.DOLLAR.getTitle();
    }
}
