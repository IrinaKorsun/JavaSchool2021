package lesnoy;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bank {
    private static BigDecimal totalAmount;
    private static int numberOfAccounts;
    private static int numberOfClients;
    private final CopyOnWriteArrayList<Account> accountList = new CopyOnWriteArrayList();
    Account account;

    public Bank() {
    }

    public static BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public static int getNumberOfClients() {
        return numberOfClients;
    }

    public void initialize(String path) {
        File file = new File(path);
        Properties property = new Properties();
        try {
            property.load(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        totalAmount = new BigDecimal(property.getProperty("total.amount"));
        numberOfAccounts = Integer.parseInt(property.getProperty("accounts.number"));
        numberOfClients = Integer.parseInt(property.getProperty("clients.number"));
    }

    public void createAccounts(int quantityAccounts, BigDecimal totalMoney) {
        BigDecimal divResult = (totalMoney.divide(new BigDecimal(quantityAccounts), MathContext.DECIMAL128));
        BigDecimal delta = (totalMoney.remainder(BigDecimal.valueOf(quantityAccounts)));

        for (int i = 0; i < quantityAccounts; i++) {
            if (i == quantityAccounts - 1) {
                account = new Account(
                        divResult.add(delta), (int) (Math.random() * 1000));
            } else {
                account = new Account(divResult, (int) (Math.random() * 1000));
            }
            accountList.add(account);
        }
    }

    public CopyOnWriteArrayList<Account> getAccountList() {
        return accountList;
    }

    public void transferMoney(BigDecimal amount, int srcAccountIndex, int dstAccountIndex) {
        Account srcAccount = null;
        Account dstAccount = null;

        Iterator<Account> accountIterator = accountList.iterator();
        while (accountIterator.hasNext()) {

            if (srcAccountIndex == account.getAccNum()) {
                srcAccount = account;
            }
            if (dstAccountIndex == account.getAccNum()) {
                dstAccount = account;
            }
        }

        Account lock1 = srcAccountIndex < dstAccountIndex ? srcAccount : dstAccount;
        Account lock2 = srcAccountIndex < dstAccountIndex ? dstAccount : srcAccount;

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock1) {
            synchronized (lock2) {
                if (srcAccount.getBalance().compareTo(amount) >= 0) {
                    srcAccount.withdrawMoney(amount);
                    dstAccount.addMoney(amount);
                }
            }
        }
    }
}