package pelipenko;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

public class Bank {
    public static int numberOfAccounts;
    public static int numberOfClients;
    public static BigDecimal maxAmount;
    public static BigDecimal entryAmount;
    private Account[] accounts;

    public Bank(String path) {
        initializeApp(path);
        accounts = new Account[numberOfAccounts];
        entryAmount = maxAmount.divide(BigDecimal.valueOf(numberOfAccounts));
        for (int i = 0; i < numberOfAccounts; i++) {
            accounts[i] = new Account(i, entryAmount);
        }
    }


    public Account[] getAccounts() {
        return accounts;
    }


    public BigDecimal getSumAmount() {
        Account[] copyOfAccounts = new Account[accounts.length];
        System.arraycopy(accounts, 0, copyOfAccounts, 0, accounts.length);
        BigDecimal result = BigDecimal.valueOf(0);
        for (Account account : copyOfAccounts) {
            result = result.add(account.getAmount());

        }
        return result;
    }


    public void runClients() {
        for (int i = 0; i < numberOfClients; i++) {
            Thread clientThread = new Thread(new ClientRunnable(this));
            clientThread.start();
        }
    }

    private void initializeApp(String path) {
        Properties properties;
        try (final InputStream stream = getClass().getClassLoader().getResourceAsStream(path)) {
            properties = new Properties();
            properties.load(stream);
            numberOfAccounts = Integer.parseInt(properties.getProperty("accounts.number"));
            maxAmount = new BigDecimal(properties.getProperty("total.amount"));
            numberOfClients = Integer.parseInt(properties.getProperty("clients.number"));
        } catch (Exception e) {
            throw new RuntimeException("Ошибка чтения файла .properties");
        }
    }
}
