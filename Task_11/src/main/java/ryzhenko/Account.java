package ryzhenko;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Account {

    private BigDecimal money;
    private int accountId;
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public Account(BigDecimal cash, int id) {
        this.money = cash;
        this.accountId = id;
    }

    /**
     * Пополнить счет
     *
     * @param cash - денежные средства
     */
    public void deposit(BigDecimal cash) {

        lock.writeLock().lock();
        try {
            this.money = this.money.add(cash);
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * Вывести со счета
     *
     * @param cash - денежные средства
     */
    public void withdraw(BigDecimal cash) {

        lock.writeLock().lock();
        try {
            this.money = this.money.subtract(cash);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public BigDecimal getMoney() {

        lock.readLock().lock();
        BigDecimal gett;
        try {
            gett = this.money;
        } finally {
            lock.readLock().unlock();
        }
        return gett;
    }

    public void setMoney(BigDecimal money) {

        lock.writeLock().lock();
        try {
            this.money = money;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int getAccountId() {
        lock.readLock().lock();
        int id;
        try {
            id = this.accountId;
        } finally {
            lock.readLock().unlock();
        }
        return id;
    }
}