package emelyanov;

import java.util.concurrent.CopyOnWriteArrayList;

public class Bank {
    public static CopyOnWriteArrayList<Account> accountsList = new CopyOnWriteArrayList<>();

    void transfer(int amount, int from, int to) {
        CopyOnWriteArrayList<Account> accounts = accountsList;
        Account accauntFrom = null;
        Account accountTo = null;
        Account accFrom = accounts.get(from);
        Account accTo = accounts.get(to);
        if (accFrom.getIndex() < accTo.getIndex()) {
            accauntFrom = accFrom;
        } else {
            accountTo = accTo;
        }
        if (accFrom.getIndex() < accTo.getIndex()) {
            accountTo = accTo;
        } else {
            accauntFrom = accFrom;
        }
        synchronized (accauntFrom) {
            synchronized (accountTo) {
                if (amount <= accounts.get(from).getBalance()) {
                    accFrom.setBalance(accauntFrom.getBalance() + amount);
                    accTo.setBalance(accountTo.getBalance() - amount);
                    System.out.println("Thread " + Thread.currentThread().getName() + " Transfer Money " + amount);
                }
            }
        }
    }
}
