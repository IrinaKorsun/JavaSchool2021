package pelipenko;

import java.math.BigDecimal;

public class Account {
    public Account(int accountID, BigDecimal amount) {
        this.accountID = accountID;
        this.amount = amount;
    }

    private int accountID;

    public int getAccountID() {
        return accountID;
    }

    private BigDecimal amount;

    public synchronized BigDecimal getAmount() {
        return amount;
    }

    public void increaseAmount(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }

    public void decreaseAmount(BigDecimal amount) {
        this.amount = this.amount.subtract(amount);
    }
}
