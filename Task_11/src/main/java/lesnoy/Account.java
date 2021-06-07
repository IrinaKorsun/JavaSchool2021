package lesnoy;

import java.math.BigDecimal;

public class Account {

    private final int accountId;
    private BigDecimal balance;

    public Account(BigDecimal balance, int accountId) {
        this.accountId = accountId;
        this.balance = balance;
    }

    /**
     * Списание денег со счета
     *
     * @param sum - сумма списания
     */
    public synchronized void withdrawMoney(BigDecimal sum) {
        balance = balance.subtract(sum);
    }

    /**
     * Зачисление денег на счет
     *
     * @param sum - сумма зачисления
     */
    public synchronized void addMoney(BigDecimal sum) {
        balance = balance.add(sum);
    }

    /**
     * Получение остатка на счете
     *
     * @return - остаток на счете
     */
    public synchronized BigDecimal getBalance() {
        return balance;
    }

    public synchronized int getAccNum() {
        return accountId;
    }
}


