package sartakova;

/**
 * Информация о счетах клиентов.
 */

public class Account {

    private int accountBalance;

    public Account(int amountOfMoney) {
        accountBalance = amountOfMoney;
    }

    public synchronized int getAmountOfMoney() {
        return accountBalance;
    }

    public synchronized void withdrawMoney(int amountOfMoney) {
        accountBalance -= amountOfMoney;
    }

    public synchronized void putMoney(int amountOfMoney) {
        accountBalance += amountOfMoney;
    }
}
