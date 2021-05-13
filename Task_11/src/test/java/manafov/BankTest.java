package manafov;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

class BankTest {
    @Test
    void goodCaseWith70ClientsAnd100Accounts() throws InterruptedException {
        Bank sber = new Bank("manafov/bank.good1.properties");
        sber.startWork();
    }

    @Test
    void goodCaseWith70ClientsAnd2Accounts() throws InterruptedException {
        Bank sber = new Bank("manafov/bank.good2.properties");
        sber.startWork();
    }

    @Test
    void negativeCaseDaemonThrowsException() throws NoSuchFieldException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InterruptedException {
        Bank sber = new Bank("manafov/bank.good1.properties");
        Field accountsField = sber.getClass().getDeclaredField("accounts");
        accountsField.setAccessible(true);
        Object accounts = accountsField.get(sber);
        Method set = List.class.getDeclaredMethod("set", int.class, Object.class);
        set.invoke(accounts, 0, new Account(new BigDecimal("10000000.00")));
        sber.startWork();
    }
}
