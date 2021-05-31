package sartakova;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;

/**
 * Информация о текущем состоянии денежных средств в банке.
 */

public class Money implements Runnable {
    static private java.util.logging.Logger LOGGER;
    private List<Account> cashAccountList;
    private BigDecimal moneyBank;
    private BigDecimal moneyСurrent;

    public Money(BigDecimal moneyBank, List<Account> cashAccountList) {
        this.moneyBank = moneyBank;
        moneyСurrent = new BigDecimal(0);
        this.cashAccountList = cashAccountList;
        LOGGER = java.util.logging.Logger.getLogger(getClass().getName());
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CopyOnWriteArrayList<Account> t = new CopyOnWriteArrayList<>(cashAccountList);

            for (Account cashAccount : cashAccountList) {
                cashAccount.getLock().lock();
                moneyСurrent = moneyСurrent.add(cashAccount.getMoney());
            }

            if (moneyСurrent.compareTo(moneyBank) != 0) {
                throw new RuntimeException();
            }

            LOGGER.log(Level.SEVERE, "Отлично, утечек не найдено. Денежный пул: " + moneyСurrent);
            moneyСurrent = BigDecimal.valueOf(0);

            for (Account cashAccount : cashAccountList) {
                cashAccount.getLock().unlock();
            }
        }
    }
}
