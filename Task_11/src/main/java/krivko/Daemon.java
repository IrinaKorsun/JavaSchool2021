package krivko;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * Daemon сверяет общую сумму в банке с суммой на всех его счетах
 */
public class Daemon extends Thread {
    private final Bank bank;

    public Daemon(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        int currentNumberTransfer = bank.getTransferCounter();
        while (true) {
            if (currentNumberTransfer == bank.getTransferCounter()) {
                continue; // если счетчик переводов не поменялся, то проверку не пускаем
            }
            currentNumberTransfer = bank.getTransferCounter();
            // Блокируем счета и по мере расчета суммы - разблокируем их
            BigDecimal sum = new BigDecimal(0);
            for (var account : bank.getAccounts()) {
                account.getLock().lock();
            }
            for (var account : bank.getAccounts()) {
                try {
                    sum = sum.add(account.getBalance());
                } finally {
                    account.getLock().unlock();
                }
            }
            if (sum.compareTo(bank.getAmountOfMoney()) == 0) {
                System.out.println("### The balance is drawn; Transfers passed: " + currentNumberTransfer);
            } else {
                System.out.println("### Balance VIOLATED!?!: amount of invoices: " + sum + " in the bank " + bank.getAmountOfMoney()
                        + "; Transfers passed: " + currentNumberTransfer);
                bank.stopClients();
                throw new RuntimeException("Balance VIOLATED!");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(bank.getPauseTheDaemonInMilliseconds());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}