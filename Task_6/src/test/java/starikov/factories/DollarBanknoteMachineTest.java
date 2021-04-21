package starikov.factories;

import org.junit.jupiter.api.Test;
import starikov.enums.BanknoteCurrency;
import starikov.models.Banknote10;
import starikov.models.Banknote100;
import starikov.models.Banknote50;

import static org.junit.jupiter.api.Assertions.*;

class DollarBanknoteMachineTest {

    DollarBanknoteMachine dm = new DollarBanknoteMachine();

    @Test
    void emmitNominal10() {
        Banknote10 d10 = dm.emitDenomination10();
        assertEquals("Номинал 10", d10.printDenomination());
        assertEquals("Американский доллар", d10.getCurrency().getTitle());
    }

    @Test
    void emmitBankNoteNominal50() {
        Banknote50 d50 = dm.emitDenomination50();
        assertEquals("Номинал 50", d50.printDenomination());
        assertEquals("Американский доллар", d50.getCurrency().getTitle());
    }

    @Test
    void emmitBankNoteNominal100() {
        Banknote100 d100 = dm.emitDenomination100();
        assertEquals("Номинал 100", d100.printDenomination());
        assertEquals("Американский доллар", d100.getCurrency().getTitle());

    }

    @Test
    void printCurrency() {
        assertEquals(BanknoteCurrency.DOLLAR.getTitle(), dm.printCurrency());
    }
}