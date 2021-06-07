package lesnoy;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Watcher implements Runnable {
    private final Bank bank;
    private final BigDecimal totalAmount;
    private final Lock readLock;
    private BigDecimal balance;
    private CopyOnWriteArrayList<Account> accounts = new CopyOnWriteArrayList();

    public Watcher(Bank bank, BigDecimal totalAmount) {
        this.bank = bank;
        this.totalAmount = totalAmount;
        readLock = new ReentrantReadWriteLock().readLock();
    }

    @Override
    public void run() {
        while (true) {
            balance = (BigDecimal.ZERO);

            if (totalAmountChecker().compareTo(totalAmount) == 0) {
                System.out.println("Wonderful! No money leaks)");
                System.out.println("Balance from property: " + totalAmount + " Actual balance = " + balance);
            } else {
                throw new RuntimeException("Balance from property: " + totalAmount + " Actual balance = " + balance);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private BigDecimal totalAmountChecker() {
        accounts = bank.getAccountList();
        Iterator<Account> accountIter = accounts.iterator();
        while (accountIter.hasNext()) {
            balance = balance.add(accountIter.next().getBalance());
        }
        return balance;
    }
}




