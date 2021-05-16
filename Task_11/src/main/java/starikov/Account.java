package starikov;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс банковского счета
 */
public class Account {
    private int id;
    private long amount;
    private final ReentrantLock lock;

    public Account(int id, long amount) {
        this.id = id;
        this.amount = amount;
        this.lock = new ReentrantLock();
    }

    public int getId() {
        return id;
    }

    public long getAmount() {
        return amount;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void increaseAmount(long value) {
        amount += value;
    }

    public void decreaseAmount(long value) {
        amount -= value;
    }

    @Override
    public String toString() {
        return String.valueOf(getAmount());
    }
}
