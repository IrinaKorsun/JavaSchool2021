package emelyanov.bank;

import emelyanov.bank.factory.BankFactory;
import emelyanov.bank.factory.BankGazprom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankGazpromTest {
    BankFactory bankFactory = new BankGazprom();

    @Test
    void checkCreateCardsBankVTB() {
        assertEquals("GazpromCard", bankFactory.createCard().getClass().getSimpleName(),
                "Ожидаемый и фактический результат не совпали");
    }

    @Test
    void checkCreateCreditsBankGazprom() {
        assertEquals("GazpromCredit", bankFactory.createCredit().getClass().getSimpleName(),
                "Ожидаемый и фактический результат не совпали");
    }

    @Test
    void checkCreateDepositsBankGazprom() {
        assertEquals("GazpromDeposit", bankFactory.createDeposit().getClass().getSimpleName(),
                "Ожидаемый и фактический результат не совпали");
    }

    @Test
    void checkCreateMortgagesBankGazprom() {
        assertEquals("GazpromMortgage", bankFactory.createMortgage().getClass().getSimpleName(),
                "Ожидаемый и фактический результат не совпали");
    }

}
