package mozzherin;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bank {
    private final CopyOnWriteArrayList<Account> bankAccountList = new CopyOnWriteArrayList<>();

    public void createAccounts(int numberOfAccounts, int totalAmount, boolean badTest) {
        for (int i = 0; i < numberOfAccounts; i++) { // создаем NUMBER_ACCOUNTS счетов
            if (badTest && i == 0) {
                Account account = new Account(totalAmount); // создаем максимально доступный лимит на первом счете
                bankAccountList.add(account);
            } else {
                Account account = new Account(totalAmount / numberOfAccounts); // равномерно распределяем деньги между счетами
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




