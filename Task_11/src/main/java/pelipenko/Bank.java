package pelipenko;


import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Properties;


import static pelipenko.RandomHelper.getRandomNumberUsingNextInt;

public class Bank {
    public static int numberOfBills;
    public static int numberOfClients;
    public static BigDecimal maxAmount;

    public Bank(String path) {
        initializeApp(path);

        accounts = new ArrayList<>(numberOfBills);

        BigDecimal entryAmount = maxAmount.divide(BigDecimal.valueOf(numberOfBills));

        for (int i = 0; i < numberOfBills; i++) {
            accounts.add(new Account(i, entryAmount));
        }
    }

    private static List<Account> accounts;
    public List<Account> getAccounts() {
        return accounts;
    }

    public BigDecimal getSum() {
        BigDecimal result = BigDecimal.valueOf(0);
        for (Account a : accounts){
            a.lockObject.lock();
        }

        for (Account a : accounts){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = result.add(a.getAmount());
        }

        for (Account a : accounts){
            a.lockObject.unlock();
        }

        return result;
    }

    public void runClients() {
        for (int i = 0; i < numberOfClients; i++) {
            int fromAccountID = getRandomNumberUsingNextInt(0, numberOfBills);

            Thread clientThread = new Thread(new ClientRunnable(fromAccountID, accounts));

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clientThread.start();
        }
    }

    private void initializeApp(String path) {
        Properties properties;
        try (final InputStream stream = getClass().getClassLoader().getResourceAsStream(path)) {
            properties = new Properties();
            properties.load(stream);
            numberOfBills = Integer.parseInt(properties.getProperty("bills.number"));
            maxAmount = new BigDecimal(properties.getProperty("total.amount"));
            numberOfClients = Integer.parseInt(properties.getProperty("clients.number"));
        } catch (Exception e) {
            throw new RuntimeException("Ошибка чтения файла .properties");
        }
    }
}
