package khoroshev;

import khoroshev.service.BankService;
import khoroshev.model.Client;
import khoroshev.model.Observer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Starter {

    public static void startProgram(String filePath) throws InterruptedException {
        BankService bankService = new BankService();
        int amount = 0;
        int accountCount = 0;
        Properties properties = new Properties();
        try (var fis = new FileInputStream(filePath)) {
            properties.load(fis);
            amount = Integer.parseInt(properties.getProperty("amount"));
            accountCount = Integer.parseInt(properties.getProperty("accountCount"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        bankService.createNewAccounts(amount, accountCount);
        Observer observer = new Observer(bankService, amount);
        observer.start();
        for (int i = 0; i < Integer.parseInt(properties.getProperty("clientCount")); i++) {
            Thread user = new Thread(new Client(bankService));
            user.start();
            user.join();
        }
    }
}
