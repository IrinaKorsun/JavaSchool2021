package podolyak;

import java.math.BigDecimal;

public class Account {

    private final int accountNumber;
    private BigDecimal accountAmount;


    public Account(int accountNumber, BigDecimal accountAmount) {
        this.accountNumber = accountNumber;
        this.accountAmount = accountAmount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
    }

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }
}
