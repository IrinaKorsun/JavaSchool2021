package komissarov;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

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
                continue;
            }
            currentNumberTransfer = bank.getTransferCounter();
            BigDecimal sum = new BigDecimal(0);
            for (Account account : bank.getAccounts()) {
                account.getLock().lock();
            }
            for (Account account : bank.getAccounts()) {
                try {
                    sum = sum.add(account.getBalance());
                } finally {
                    account.getLock().unlock();
                }
            }
            if (sum.compareTo(bank.getAmountOfMoney()) == 0) {
                System.out.println("Successful transfers: " + currentNumberTransfer);
            } else {
                System.out.println("Money leak. Bank stopped.");
                bank.stopClients();
                throw new RuntimeException("Money leak");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}