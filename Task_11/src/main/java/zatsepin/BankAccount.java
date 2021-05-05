package zatsepin;

import java.math.BigInteger;

/**
 * Represents a bank account.
 */
public class BankAccount {
    private BigInteger balance;

    /**
     * Creates an bank account with the specified initial amount of money.
     */
    public BankAccount(String initialAmount) {
        balance = new BigInteger(initialAmount);
    }

    /**
     * Returns the current account balance.
     */
    public synchronized BigInteger getBalance() {
        return balance;
    }

    /**
     * Withdraws the specified amount from the account.
     */
    public synchronized void withdrawMoney(int amount) {
        balance = balance.subtract(BigInteger.valueOf(amount));
    }

    /**
     * Credits the specified amount to the account.
     */
    public synchronized void putMoney(int amount) {
        balance = balance.add(BigInteger.valueOf(amount));
    }
}
