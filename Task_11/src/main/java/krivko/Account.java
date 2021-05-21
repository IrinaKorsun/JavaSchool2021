package krivko;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Счет банка
 */
public class Account {
    private BigDecimal balance;
    private final int idAccount;
    private final ReentrantLock lock;

    public Account(int idAccount, BigDecimal balance) {
        this.idAccount = idAccount;
        this.balance = balance;
        this.lock = new ReentrantLock();
    }

    public int getIdAccount() {
        return idAccount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void addBalance(BigDecimal sum) {
        balance = balance.add(sum);
    }

    public void subtractBalance(BigDecimal sum) {
        balance = balance.subtract(sum);
    }

    public ReentrantLock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "{Account: " + idAccount + ", Balance: " + getBalance() + "}";
    }
}