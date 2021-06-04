package emelyanov;

import java.util.Objects;

public class Account {
    private long acctNumber;
    private int balance;
    private int index;

    Account(long account, int initialBalance, int index) {
        this.acctNumber = account;
        this.balance = initialBalance;
        this.index = index;
    }

    int getBalance() {
        return balance;
    }

    public int getIndex() {
        return index;
    }

    void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return acctNumber == account.acctNumber &&
                balance == account.balance &&
                index == account.index;
    }

    @Override
    public int hashCode() {

        return Objects.hash(acctNumber, balance, index);
    }
}
