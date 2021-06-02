package ryzhenko;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Daemon implements Runnable {

    private BigDecimal totalMoney;
    private Bank bank;
    private CopyOnWriteArrayList<Account> accounts;

    public Daemon(Bank bank, BigDecimal cash) {
        this.totalMoney = cash;
        this.bank = bank;
    }

    @Override
    public void run() {
        while (true) {
            accounts = new CopyOnWriteArrayList<>(bank.getAccounts());
            Iterator<Account> iterator = accounts.iterator();
            BigDecimal money = BigDecimal.ZERO;
            while (iterator.hasNext()) {
                money = money.add(iterator.next().getMoney());
            }
            if (money.compareTo(totalMoney) != 0) {
                throw new RuntimeException("Leak detected!");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}