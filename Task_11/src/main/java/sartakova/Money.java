package sartakova;

import java.util.concurrent.CopyOnWriteArrayList;


/**
 * Информация о текущем состоянии денежных средств в банке.
 */

public class Money {
    private final CopyOnWriteArrayList<Account> bankAccountList = new CopyOnWriteArrayList<>();

    public void createAccounts(int numberOfAccounts, int totalAmount, boolean badTest) {
        for (int i = 0; i < numberOfAccounts; i++) {
            if (badTest && i == 0) {
                Account account = new Account(totalAmount);
                bankAccountList.add(account);
            } else {
                Account account = new Account(totalAmount / numberOfAccounts);
                bankAccountList.add(account);
            }
        }
    }

    public CopyOnWriteArrayList<Account> getBankAccountList() {
        return bankAccountList;
    }

    public void transferMoney(int amount, int srcAccountIndex, int dstAccountIndex) {
        Account srcAccount = bankAccountList.get(srcAccountIndex);
        Account dstAccount = bankAccountList.get(dstAccountIndex);

        Account lock1 = srcAccountIndex < dstAccountIndex ? srcAccount : dstAccount;
        Account lock2 = srcAccountIndex < dstAccountIndex ? dstAccount : srcAccount;

        synchronized (lock1) {
            synchronized (lock2) {
                if (srcAccount.getAmountOfMoney() >= amount) {
                    srcAccount.withdrawMoney(amount);
                    dstAccount.putMoney(amount);
                }
            }
        }
    }
}
