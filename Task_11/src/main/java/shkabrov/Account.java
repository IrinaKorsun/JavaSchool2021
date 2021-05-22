package shkabrov;

import java.math.BigDecimal;

/**
 * Банковский счет.
 */
public class Account {
    private int accountNumber;
    private BigDecimal amountOfMoney;

    public Account(int accountNumber, BigDecimal amountOfMoney) {
        this.accountNumber = accountNumber;
        this.amountOfMoney = amountOfMoney;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(BigDecimal amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Account clone() {
        return new Account(this.accountNumber, this.getAmountOfMoney());
    }
}
