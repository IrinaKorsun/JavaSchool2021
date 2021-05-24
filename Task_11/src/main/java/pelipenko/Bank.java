package pelipenko;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

import static pelipenko.RandomHelper.getRandomNumberUsingNextInt;

public class Bank {
    public static int numberOfBills;
    public static int numberOfClients;
    public static BigDecimal maxAmount;

    public Bank(String path) throws IOException {
        initializeApp(path);

        accounts = new ArrayList<>(numberOfBills);

        BigDecimal entryAmount = maxAmount.divide(BigDecimal.valueOf(numberOfBills));

        for (int i = 0; i < numberOfBills; i++) {
            accounts.add(new Account(i, entryAmount));
        }
    }

//    public void setMaxAmountMoney(BigDecimal totalAmountMoney) {
//        this.maxAmount = totalAmountMoney;
//    }

    private static List<Account> accounts;
    public List<Account> getAccounts() {
        return accounts;
    }

    public void runClients() {
        for (int i = 0; i < numberOfClients; i++) {
            int fromAccountID = getRandomNumberUsingNextInt(0, numberOfBills);

            Thread clientThread = new Thread(new ClientRunnable(fromAccountID, accounts));

            clientThread.start();
        }
    }

    private void initializeApp(String path) throws IOException {
        Properties properties;
        try {
            properties = new Properties();
            properties.load(new FileReader(path));
            numberOfBills = Integer.parseInt(properties.getProperty("bills.number"));
            maxAmount = new BigDecimal(properties.getProperty("total.amount"));
            numberOfClients = Integer.parseInt(properties.getProperty("clients.number"));
        } catch (NumberFormatException | FileNotFoundException exception) {
            throw new IOException("Ошибка чтения файла .properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
