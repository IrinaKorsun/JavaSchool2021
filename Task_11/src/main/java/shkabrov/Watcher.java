package shkabrov;

import java.math.BigDecimal;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Демон-наблюдатель - следит за отсутствием утечек денежных средств.
 */
public class Watcher implements Runnable {
    private Bank bank;

    public Watcher(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BigDecimal checkTotalAmount = new BigDecimal(0.0);
            CopyOnWriteArrayList<Account> testAccounts = bank.getAccounts();
            for (Account currentAccount : testAccounts) {
                checkTotalAmount = checkTotalAmount.add(currentAccount.getAmountOfMoney());
            }
            if (checkTotalAmount.compareTo(bank.getTotalAmountOfMoney()) != 0) {
                System.err.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n" +
                        "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n" +
                        "ERROR: Daemon detected a money leak" +
                        "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +
                        "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
            }
        }
    }
}
