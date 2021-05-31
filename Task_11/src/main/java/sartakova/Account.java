package sartakova;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;

/**
 * Информация о счетах клиентов.
 */

public class Account {
    static private java.util.logging.Logger LOGGER;
    private String name;
    private BigDecimal money;
    private ReentrantLock lock;

    public Account(String name, BigDecimal integer) {
        this.name = name;
        this.money = integer;
        LOGGER = java.util.logging.Logger.getLogger(getClass().getName());
        lock = new ReentrantLock();
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    /**
     * Суммрование определенной суммы денег к текущему остатку.
     *
     * @param money начисляемая сумма.
     */
    public void addMoney(BigDecimal money) {
        this.money = this.money.add(money);
        LOGGER.log(Level.INFO, Thread.currentThread().getName() + ": На Ваш счет " + name + " зачислена следующая сумма: " +
                money + ". Остаток: " + this.money);
    }

    /**
     * Списание определенной суммы денег с текущего остатка.
     *
     * @param money списываемая сумма.
     * @throws Exception если сумма перевода превышает остаток на счете.
     */
    public boolean subMoney(BigDecimal money) throws Exception {
        if (this.money.compareTo(money) > -1) {
            this.money = this.money.subtract(money);
            LOGGER.log(Level.INFO, Thread.currentThread().getName() + ": С Вашего счета " + name + " списана следующая сумма: " +
                    money + ". Остаток: " + this.money);
            return true;
        } else {
            throw new Exception("Недостаточно средств на счете.");
        }
    }
}
