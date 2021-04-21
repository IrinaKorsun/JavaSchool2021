package starikov.factories;

import org.junit.jupiter.api.Test;
import starikov.models.Banknote10;
import starikov.models.Banknote100;
import starikov.models.Banknote50;
import starikov.enums.BanknoteCurrency;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EuroBanknoteMachineTest {

    EuroBanknoteMachine em = new EuroBanknoteMachine();

    @Test
    void emmitBankNoteNominal10() {
        Banknote10 e10 = em.emitDenomination10();
        assertEquals("Номинал 10", e10.printDenomination());
        assertEquals("Европейский евро", e10.getCurrency().getTitle());
    }

    @Test
    void emmitBankNoteNominal50() {
        Banknote50 e50 = em.emitDenomination50();
        assertEquals("Номинал 50", e50.printDenomination());
        assertEquals("Европейский евро", e50.getCurrency().getTitle());
    }

    @Test
    void emmitBankNoteNominal100() {
        Banknote100 e100 = em.emitDenomination100();
        assertEquals("Номинал 100", e100.printDenomination());
        assertEquals("Европейский евро", e100.getCurrency().getTitle());
    }

    @Test
    void printCurrency() {
        assertEquals(BanknoteCurrency.EURO.getTitle(), em.printCurrency());
    }
}