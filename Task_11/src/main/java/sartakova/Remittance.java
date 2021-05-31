package sartakova;

import java.math.BigDecimal;
import java.util.logging.Level;

public class Remittance implements Runnable{
    static private java.util.logging.Logger LOGGER;
    private String name;
    private Account sender;
    private Account recipient;
    private BigDecimal amountMoney;

    public Remittance(String name, Account sender, Account recipient, BigDecimal amountMoney) {
        this.name = name;
        this.sender = sender;
        this.recipient = recipient;
        this.amountMoney = amountMoney;
        LOGGER = java.util.logging.Logger.getLogger(getClass().getName());
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (sender.getLock().tryLock()) {
            if (recipient.getLock().tryLock()) {
                try {
                    sender.subMoney(amountMoney);
                    recipient.addMoney(amountMoney);
                } catch (Exception e) {
                    LOGGER.log(Level.INFO, Thread.currentThread().getName() + ": На счету " + name + " недостаточно средств. " +
                            "Операцию можно попробовать произвести позднее, " + "либо осуществить перевод суммы поменьше. " +
                            "Необходимо перевести: " + amountMoney + ". Доступно: " + sender.getMoney());
                    amountMoney = BigDecimal.valueOf(0);
                } finally {
                    sender.getLock().unlock();
                    recipient.getLock().unlock();
                }
            } else {
                sender.getLock().unlock();
            }
        }
    }
}
