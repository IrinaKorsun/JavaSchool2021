package komissarov;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private BigDecimal balance;
    private final UUID accountUUID;
    private final ReentrantLock lock;

    public Account(UUID accountUUID, BigDecimal balance) {
        this.accountUUID = accountUUID;
        this.balance = balance;
        this.lock = new ReentrantLock();
    }

    public BigDecimal getBalance() {
        return balance;
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
        return accountUUID.toString();
    }
}