package khoroshev.model;

import java.math.BigInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private BigInteger moneyCount;
    private final Lock writeLock;

    public Account(Integer moneyCount) {
        this.moneyCount = new BigInteger(String.valueOf(moneyCount));
        writeLock = new ReentrantLock();
    }

    public BigInteger getMoneyCount() {
        return moneyCount;
    }

    public synchronized void setNewMoneyCount(int moneyCount) {
        this.moneyCount = new BigInteger(String.valueOf(getMoneyCount().intValue() + moneyCount));
    }

    public Lock getWriteLock() {
        return writeLock;
    }

}
