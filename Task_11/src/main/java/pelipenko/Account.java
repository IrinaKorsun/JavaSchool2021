package pelipenko;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    Lock lockObject = new ReentrantLock();

    public Account(int accountID, BigDecimal amount) {
        this.accountID = accountID;
        this.amount = amount;
    }

    private int accountID;

    public int getAccountID() {
        return accountID;
    }

    private BigDecimal amount;



    public BigDecimal getAmount() {
        try {
            lockObject.lock();
            return amount;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockObject.unlock();
        }

        return BigDecimal.valueOf(0);
    }

    public void increaseAmount(BigDecimal amount) {
        try {
            lockObject.lock();
            this.amount = this.amount.add(amount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockObject.unlock();
        }
    }

    public void decreaseAmount(BigDecimal amount) {
        try {
            lockObject.lock();
            this.amount = this.amount.subtract(amount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockObject.unlock();
        }
    }
}
