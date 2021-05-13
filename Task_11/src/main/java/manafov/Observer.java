package manafov;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Observer implements Runnable {
    private Bank bank;
    private Lock readLock;

    public Observer(Bank bank) {
        this.bank = bank;
        readLock = new ReentrantReadWriteLock().readLock();
    }

    @Override
    public void run() {
        while (true) {
            if (!checkTotalAmount())
                throw new RuntimeException("Сумма денег на счетах не равна " + bank.getTotalAmount());
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Проверяет, нет ли утечки средств.
     *
     * @return true, если текущая сумма средств на счетах равна начальной сумме, false - в противном случае
     */
    private boolean checkTotalAmount() {
        List<Account> accounts;
        readLock.lock();
        try {
            accounts = new ArrayList<>(bank.getAccounts());
        } finally {
            readLock.unlock();
        }
        BigDecimal currentAmount = new BigDecimal("0.00");
        for (Account account : accounts) {
            currentAmount = currentAmount.add(account.getAmount());
        }
        return currentAmount.equals(bank.getTotalAmount());
    }
}
