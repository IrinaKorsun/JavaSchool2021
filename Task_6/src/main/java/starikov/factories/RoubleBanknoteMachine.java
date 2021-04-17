package starikov.factories;

import starikov.enums.BanknoteCurrency;
import starikov.interfaces.BanknoteMachine;
import starikov.models.Banknote10;
import starikov.models.Banknote100;
import starikov.models.Banknote50;

/**
 * Станок для выпуска рублевых банкнот
 */
public class RoubleBanknoteMachine implements BanknoteMachine {

    @Override
    public Banknote10 emitDenomination10() {
        return new Banknote10(BanknoteCurrency.ROUBLE);
    }

    @Override
    public Banknote50 emitDenomination50() {
        return new Banknote50(BanknoteCurrency.ROUBLE);
    }

    @Override
    public Banknote100 emitDenomination100() {
        return new Banknote100(BanknoteCurrency.ROUBLE);
    }

    @Override
    public String printCurrency() {
        return BanknoteCurrency.ROUBLE.getTitle();
    }
}
