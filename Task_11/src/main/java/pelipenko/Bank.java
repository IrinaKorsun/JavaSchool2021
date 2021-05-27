package pelipenko;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bank {
    public static int numberOfAccounts;
    public static int numberOfClients;
    public static BigDecimal maxAmount;
    public static BigDecimal entryAmount;

    public Bank(String path) {
        initializeApp(path);

        accounts = new CopyOnWriteArrayList<>();

        entryAmount = maxAmount.divide(BigDecimal.valueOf(numberOfAccounts));

        for (int i = 0; i < numberOfAccounts; i++) {
            accounts.add(new Account(i, entryAmount));
        }
    }

    private CopyOnWriteArrayList<Account> accounts;
    public CopyOnWriteArrayList<Account> getAccounts() {
        return accounts;
    }

    public ArrayList<Account> getCopyAccounts(){
        ArrayList<Account> result = new ArrayList<>();

        for (Account account : accounts){
            Account copy = new Account(account.getAccountID(), account.getAmount());
            result.add(copy);
        }

        return result;
    }

    public BigDecimal getSumAmount(){
        BigDecimal result = BigDecimal.valueOf(0);

        for (Account account : accounts){
            result = result.add(account.getAmount());
        }

        return result;
    }

    public void runClients() {
        for (int i = 0; i < 2; i++) {
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
