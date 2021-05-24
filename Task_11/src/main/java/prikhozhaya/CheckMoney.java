package prikhozhaya;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;

/**
 * Содержит сведения о текущем состоянии денежных средств в банке.
 */
public class CheckMoney implements Runnable {
    static private java.util.logging.Logger LOGGER;
    private List<CashAccount> cashAccountList;
    private BigDecimal moneyBank;
    private BigDecimal moneyСurrent;

    public CheckMoney(BigDecimal moneyBank, List<CashAccount> cashAccountList) {
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
            CopyOnWriteArrayList<CashAccount> t = new CopyOnWriteArrayList<>(cashAccountList);

            for (CashAccount cashAccount : cashAccountList) {
                cashAccount.getLock().lock();
                moneyСurrent = moneyСurrent.add(cashAccount.getMoney());
            }

            if (moneyСurrent.compareTo(moneyBank) != 0) {
                throw new RuntimeException();
            }

            LOGGER.log(Level.SEVERE, "Все ок, утечек нет. Денежный пул: " + moneyСurrent);
            moneyСurrent = BigDecimal.valueOf(0);

            for (CashAccount cashAccount : cashAccountList) {
                cashAccount.getLock().unlock();
            }
        }
    }
}
