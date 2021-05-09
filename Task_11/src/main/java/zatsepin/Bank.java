package zatsepin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Containing a list of bank accounts and performing money transfer operations.
 */
public class Bank {
    private List<BankAccount> accounts = new ArrayList<>();

    /**
     * Creates a bank object by creating a specified number of accounts
     * and evenly distributing a pool of money among them.
     *
     * @param numberOfAccounts total number of accounts
     * @param totalAmount total amount of money
     * @return bank object with specified characteristics
     */
    public static Bank createWithGeneration(int numberOfAccounts, int totalAmount) {
        Bank bank = new Bank();
        int avgAmount = totalAmount / numberOfAccounts;
        int remainder = totalAmount % numberOfAccounts;
        for (int i = 0; i < numberOfAccounts - 1; i++) {
            bank.accounts.add(new BankAccount(Integer.toString(avgAmount)));
        }
        bank.accounts.add(new BankAccount(Integer.toString(avgAmount + remainder)));
        return bank;
    }

    /**
     * Performs money transfer.
     *
     * @param amount transfer amount
     * @param fromAccountIndex index of the bank account object from which the transfer is made
     * @param toAccountIndex index of the bank account object to which the transfer is made
     * @throws Exception if insufficient funds on the account
     */
    public void transferMoney(int amount, int fromAccountIndex, int toAccountIndex) throws Exception {
        BankAccount fromAccount = accounts.get(fromAccountIndex);
        BankAccount toAccount = accounts.get(toAccountIndex);
        int fromHash = Objects.hashCode(fromAccount);
        int toHash = Objects.hashCode(toAccount);

        if (fromHash < toHash) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    transfer(amount, fromAccount, toAccount);
                }
            }
        } else {
            synchronized (toAccount) {
                synchronized (fromAccount) {
                    transfer(amount, fromAccount, toAccount);
                }
            }
        }
    }

    /**
     * An helper method to transfer money.
     * @param amount transfer amount
     * @param fromAccount bank account object from which the transfer is made
     * @param toAccount bank account object to which the transfer is made
     * @throws Exception if insufficient funds on the account
     */
    private void transfer(int amount, BankAccount fromAccount, BankAccount toAccount) throws Exception {
        if (fromAccount.getBalance().intValue() < amount) {
            throw new Exception("Insufficient funds on the account!");
        } else {
            fromAccount.withdrawMoney(amount);
            toAccount.putMoney(amount);
            System.out.println("Thread " + Thread.currentThread().getName() + " Transfer Money " + amount);
        }
    }

    /**
     * Checks if the specified account has the required amount.
     *
     * @param amount required amount
     * @param accountIndex index of the bank account object
     * @return true if specified account has the required amount
     */
    public boolean checkAccountBalance(int amount, int accountIndex) {
        return accounts.get(accountIndex).getBalance().intValue() >= amount;
    }

    /**
     * Returns a list of all bank accounts.
     */
    public List<BankAccount> getAccounts() {
        return accounts;
    }
}
