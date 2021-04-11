package emelyanov;

import emelyanov.BankFactory;
import emelyanov.banks.BankVTB;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankVTBTest {
    BankFactory bankFactory = new BankVTB();

    @Test
    void checkCreateCardsBankVTB() {
        assertEquals("VTBCard", bankFactory.createCard().getClass().getSimpleName(),
                "Ожидаемый и фактический результат не совпали");
    }

    @Test
    void checkCreateCreditsBankVTB() {
        assertEquals("VTBCredit", bankFactory.createCredit().getClass().getSimpleName(),
                "Ожидаемый и фактический результат не совпали");
    }

    @Test
    void checkCreateDepositsBankVTB() {
        assertEquals("VTBDeposit", bankFactory.createDeposit().getClass().getSimpleName(),
                "Ожидаемый и фактический результат не совпали");
    }

    @Test
    void checkCreateMortgagesBankVTB() {
        assertEquals("VTBMortgage", bankFactory.createMortgage().getClass().getSimpleName(),
                "Ожидаемый и фактический результат не совпали");
    }
}
