package emelyanov;

import emelyanov.BankFactory;
import emelyanov.banks.BankSberbank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SberbankTest {

    BankFactory bankFactory = new BankSberbank();

    @Test
    void checkCreateCardsBankSberbank() {
        assertEquals("SberbankCard", bankFactory.createCard().getClass().getSimpleName(),
                "Ожидаемый и фактический результат не совпали");
    }

    @Test
    void checkCreateCreditsBankSberbank() {
        assertEquals("SberbankCredit", bankFactory.createCredit().getClass().getSimpleName(),
                "Ожидаемый и фактический результат не совпали");
    }

    @Test
    void checkCreateDepositsBankSberbank() {
        assertEquals("SberbankDeposit", bankFactory.createDeposit().getClass().getSimpleName(),
                "Ожидаемый и фактический результат не совпали");
    }

    @Test
    void checkCreateMortgagesBankSberbank() {
        assertEquals("SberbankMortgage", bankFactory.createMortgage().getClass().getSimpleName(),
                "Ожидаемый и фактический результат не совпали");
    }
}
