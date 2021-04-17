package starikov.factories;

import org.junit.jupiter.api.Test;
import starikov.models.Banknote10;
import starikov.models.Banknote100;
import starikov.models.Banknote50;
import starikov.enums.BanknoteCurrency;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoubleBanknoteMachineTest {

    RoubleBanknoteMachine rm = new RoubleBanknoteMachine();

    @Test
    void emmitBankNoteNominal10() {
        Banknote10 r10 = rm.emitDenomination10();
        assertEquals("Номинал 10", r10.printDenomination());
        assertEquals("Российский рубль", r10.getCurrency().getTitle());
    }

    @Test
    void emmitBankNoteNominal50() {
        Banknote50 r50 = rm.emitDenomination50();
        assertEquals("Номинал 50", r50.printDenomination());
        assertEquals("Российский рубль", r50.getCurrency().getTitle());
    }

    @Test
    void emmitBankNoteNominal100() {
        Banknote100 r100 = rm.emitDenomination100();
        assertEquals("Номинал 100", r100.printDenomination());
        assertEquals("Российский рубль", r100.getCurrency().getTitle());
    }

    @Test
    void printCurrency() {
        assertEquals(BanknoteCurrency.ROUBLE.getTitle(), rm.printCurrency());
    }
}