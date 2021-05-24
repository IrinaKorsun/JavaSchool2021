package prikhozhaya;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;

/**
 * Содержит сведения о счетах клиентов.
 */
public class CashAccount {
    static private java.util.logging.Logger LOGGER;
    private String name;
    private BigDecimal money;
    private ReentrantLock lock;

    public CashAccount(String name, BigDecimal integer) {
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
     * Прибавляет к текущему остатку на счете определенную сумму денег.
     *
     * @param money сумма, которую нужно начислить.
     */
    public void addMoney(BigDecimal money) {
        this.money = this.money.add(money);
        LOGGER.log(Level.INFO, Thread.currentThread().getName() + ": На счет " + name + " поступила следующая сумма: " +
                money + ". Доступно: " + this.money);
    }

    /**
     * Отнимает от текущего остатка на счете определенную сумму денег.
     *
     * @param money сумма, которую нужно списать.
     * @throws Exception если сумма перевода превышает остаток на счете.
     */
    public boolean subMoney(BigDecimal money) throws Exception {
        if (this.money.compareTo(money) > -1) {
            this.money = this.money.subtract(money);
            LOGGER.log(Level.INFO, Thread.currentThread().getName() + ": Со счета " + name + " снята следующая сумма: " +
                    money + ". Доступно: " + this.money);
            return true;
        } else {
            throw new Exception("Недостаточно средств на счете.");
        }
    }
}
