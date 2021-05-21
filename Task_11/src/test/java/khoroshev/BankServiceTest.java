package khoroshev;

import khoroshev.model.Account;
import khoroshev.service.BankService;
import khoroshev.model.Client;
import khoroshev.model.Observer;
import khoroshev.util.RandomUtil;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BankServiceTest {

    @Test
    public void transferTestSuccess() throws InterruptedException {
        Starter.startProgram("src/test/resources/khoroshev/config.properties");
    }

    @Test
    public void transferTestWithWarning() throws InterruptedException {
        BankService bankService = new BankService();
        int amount = 0;
        int accountCount = 0;
        Properties properties = new Properties();
        try (var fis = new FileInputStream("src/test/resources/khoroshev/config.properties")) {
            properties.load(fis);
            amount = Integer.parseInt(properties.getProperty("amount"));
            accountCount = Integer.parseInt(properties.getProperty("accountCount"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        bankService.createNewAccounts(amount, accountCount);
        Account account = bankService.getBank().getAccounts().get(RandomUtil.getRandomUUID(bankService.getBank()
                .getAccounts()));
        account.setNewMoneyCount(amount + 1);
        Observer observer = new Observer(bankService, amount);
        observer.start();
        for (int i = 0; i < Integer.parseInt(properties.getProperty("clientCount")); i++) {
            Thread user = new Thread(new Client(bankService));
            user.start();
            user.join();
        }
    }

    @Test
    public void transferTestWithTwoAccount() throws InterruptedException {
        Starter.startProgram("src/test/resources/khoroshev/twoAccountConfig.properties");
    }
}
