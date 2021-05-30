package lesnoy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PositiveTestWith2Accounts {
    Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
    }

    @Test
    void positiveTestWith2Accounts() {
        bank.initialize("src/main/resources/lesnoy/conf3.properties");
        List<Integer> accountNum = new ArrayList<>();
        bank.createAccounts(Bank.getNumberOfAccounts(), Bank.getTotalAmount());
        for (Account acc : bank.getAccountList()) {
            accountNum.add(acc.getAccNum());
        }

        Thread watcher = new Thread(new Watcher(bank, Bank.getTotalAmount()));
        watcher.setDaemon(true);
        watcher.start();

        ExecutorService executor = Executors.newFixedThreadPool(Bank.getNumberOfAccounts());
        for (int i = 0; i < Bank.getNumberOfClients(); i++) {
            executor.execute(new Client(bank,
                    ((new BigDecimal(Math.random()).multiply(Bank.getTotalAmount()).divide(new BigDecimal(Bank.getNumberOfAccounts()), MathContext.DECIMAL128))),
                    accountNum.get((int) (Math.random() * accountNum.size())),
                    accountNum.get((int) (Math.random() * accountNum.size()))));
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}